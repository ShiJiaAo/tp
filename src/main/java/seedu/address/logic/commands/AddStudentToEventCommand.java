package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;

/**
 * Allows the TA to add student details to an event within one command instead of multiple commands
 */
public class AddStudentToEventCommand extends Command {
    public static final String COMMAND_WORD = "addStudent";
    public static final String MESSAGE_SUCCESS = "Student at specified index added to event";
    public static final String TUTORIAL_STRING = "tutorial";
    private final Index index;
    private final String eventName;
    private final String eventType;

    /**
     * Constructs an AddStudentToEventCommand object to add the student at the specified index
     * to an event of the specified type and name.
     *
     * @param index the index of the student within the student list to be added.
     * @param name the name of the event the student will be added into.
     * @param type the type of the event the student will be added into.
     */
    public AddStudentToEventCommand(Index index, String name, String type) {
        this.index = index;
        this.eventName = name;
        this.eventType = type;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        //todo: fix case where event does not exist
        if (this.eventType.equals(TUTORIAL_STRING)) {
            model.addStudentToTutorial(this.index, this.eventName);
        } else {
            model.addStudentToLab(this.index, this.eventName);
        }
        return new CommandResult(String.format(MESSAGE_SUCCESS));
    }
}
