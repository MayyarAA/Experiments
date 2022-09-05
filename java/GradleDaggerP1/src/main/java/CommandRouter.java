import dagger.Component;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

final class CommandRouter {
    private final Map<String, Command> commands = Collections.emptyMap();
    @Inject
    public CommandRouter(HelloWorldCommand helloWorldCommand){
        commands.put(helloWorldCommand.key(), helloWorldCommand);

    }
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