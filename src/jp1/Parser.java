package jp1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
	private Unit rootUnit = null;
	private Unit currentUnit = null;
	private String unitName = null;

	private BufferedReader br = null;

	public static void main(String[] args) throws IOException, Exception {
		Parser parser = new Parser();
		String path = "test.ajsprint";
		parser.parse(path);
	}

	public void parse(String path) throws IOException, Exception {

		br = new BufferedReader(new FileReader(path));
		String line;
		while (null != (line = br.readLine())) {
			for (Pair<Pattern, Consumer<Matcher>> pair : getPatterns()) {
				Matcher matcher = pair.getKey().matcher(line);
				if (matcher.matches()) {
					pair.getValue().accept(matcher);
				}
			}
		}
		traversalPrint(rootUnit, 0);
	}

	private List<Pair<Pattern, Consumer<Matcher>>> getPatterns()
			throws Exception {
		List<Pair<Pattern, Consumer<Matcher>>> patterns = new ArrayList<Pair<Pattern, Consumer<Matcher>>>();

		Consumer<Matcher> consumer;

		// unit
		consumer = (Matcher matcher) -> unitName = matcher.group(1);
		patterns.add(new Pair<Pattern, Consumer<Matcher>>(Pattern
				.compile(".*?unit=(.*?),(.*?),(.*?),(.*?);"), consumer));

		// ty
		consumer = (Matcher matcher) -> {
			String unitType = matcher.group(1);
			Unit unit = null;

			switch (unitType) {
			case "n":
				unit = new JobNet();
				break;
			case "j":
				unit = new UnixJob();
				break;
			default:
				unit = new NotImplementedUnit();
				break;
			}

			unit.setUnitName(unitName);
			unit.setParent(currentUnit);
			unit.setUnitType(unitType);

			if (null == rootUnit) {
				rootUnit = unit;
			}
			if (null != currentUnit) {
				((JobNet) currentUnit).addChild(unit);
			}
			currentUnit = unit;
		};

		patterns.add(new Pair<Pattern, Consumer<Matcher>>(Pattern
				.compile(".*?ty=(.+);$"), consumer));

		// sz
		consumer = (Matcher matcher) -> {
			currentUnit.setHorizontalIconCount(matcher.group(1));
			currentUnit.setVerticalIconCount(matcher.group(2));
		};

		patterns.add(new Pair<Pattern, Consumer<Matcher>>(Pattern
				.compile(".*?sz=(.+)x(.+);$"), consumer));

		// ar
		consumer = (Matcher matcher) -> {
			((JobNet) currentUnit).addArrow(new Arrow(matcher.group(1), matcher
					.group(2), matcher.group(3)));
		};

		patterns.add(new Pair<Pattern, Consumer<Matcher>>(Pattern
				.compile(".*?ar=\\(s=(.+),t=(.+),(.+)\\);$"), consumer));

		// el
		consumer = (Matcher matcher) -> {
			((JobNet) currentUnit).addElement(new Element(matcher.group(1),
					matcher.group(2), matcher.group(3)));
		};

		patterns.add(new Pair<Pattern, Consumer<Matcher>>(Pattern
				.compile(".*?el=(.+),(.+),(.+);$"), consumer));

		// }
		consumer = (Matcher matcher) -> currentUnit = currentUnit.getParent();
		patterns.add(new Pair<Pattern, Consumer<Matcher>>(Pattern
				.compile(".*?\\}$"), consumer));

		// cm
		consumer = (Matcher matcher) -> currentUnit
				.setComment(matcher.group(1));
		patterns.add(new Pair<Pattern, Consumer<Matcher>>(Pattern
				.compile(".*?cm=(.*);$"), consumer));

		// un
		consumer = (Matcher matcher) -> ((UnixJob) currentUnit)
				.setExecutionUserName(matcher.group(1));
		patterns.add(new Pair<Pattern, Consumer<Matcher>>(Pattern
				.compile(".*?un=(.*);$"), consumer));

		// te
		consumer = (Matcher matcher) -> ((UnixJob) currentUnit)
				.setCommandText(matcher.group(1));
		patterns.add(new Pair<Pattern, Consumer<Matcher>>(Pattern
				.compile(".*?te=(.*);$"), consumer));

		return patterns;
	}

	void traversalPrint(Unit unit, int depth) {
		if (null == unit) {
			return;
		}
		for (int i = 0; i < depth; ++i) {
			System.out.print("\t");
		}
		if (unit instanceof JobNet) {
			System.out.println(unit);
			for (Unit childUnit : ((JobNet) unit).getChildren()) {
				traversalPrint(childUnit, depth + 1);
			}
		}
		if (unit instanceof UnixJob) {
			System.out.println(unit);
		}
	}
}
