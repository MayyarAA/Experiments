import java.util.List;

public interface Command {
    /**
     * String token that signifies this command should be selected (e.g.: "deposit",
     * "withdraw")
     */
    String key();

    Status handleInput(List<String> input);

}