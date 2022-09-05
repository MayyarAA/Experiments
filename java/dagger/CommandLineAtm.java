import java.util.*;

enum Status {
	INVALID, HANDLED
}

class CommandLineAtm {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		CommandRouter commandRouter = new CommandRouter();

		while (scanner.hasNextLine()) {
			commandRouter.route(scanner.nextLine());
		}
	}
}

interface Command {
	/**
	 * String token that signifies this command should be selected (e.g.: "deposit",
	 * "withdraw")
	 */
	String key();

	Status handleInput(List<String> input);

}

// import package.Command.
final class CommandRouter {
	private final Map<String, Command> commands = Collections.emptyMap();

	Status route(String input) {
		List<String> splitInput = split(input);
		if (splitInput.isEmpty()) {
			return invalidCommand(input);
		}
		String commandKey = splitInput.get(0);
		Command command = commands.get(commandKey);
		if (command == null) {
			return invalidCommand(input);
		}
		Status status = command.handleInput(splitInput.subList(1, splitInput.size()));
		if (status == Status.INVALID) {
			System.out.println(commandKey + ": invalid arguments");
		}
		return status;
	}

	private Status invalidCommand(String input) {
		System.out.println(String.format("couldn't understand \"%s\". please try again.", input));
		return Status.INVALID;
	}

	// Split on whitespace
	private static List<String> split(String string) {
		String[] arr = string.split(" ");
		List<String> list = new ArrayList<>();
		for (String str : arr) {
			list.add(str);
		}
		return list;
	}

}
