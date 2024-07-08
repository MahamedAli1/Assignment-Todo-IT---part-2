import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class App {
    public static void main(String[] args) {
        // Create a list of app users
        List<AppUser> appUsers = new ArrayList<>();
        appUsers.add(new AppUser("Mohamed_Ali", "password123", AppRole.ROLE_APP_USER));
        appUsers.add(new AppUser("Mohamed_Ali", "password456", AppRole.ROLE_APP_ADMIN));

        // Create a list of persons with credentials
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1, "Mohamed", "Ali", "Mohamed.Ali@example.com"));
        persons.get(0).setCredentials(appUsers.get(0));
        persons.add(new Person(2, "Mohamed", "A", "Mohamed.A@example.com"));
        persons.get(1).setCredentials(appUsers.get(1));

        // Create a list of todo items
        List<TodoItem> todoItems = new ArrayList<>();
        todoItems.add(new TodoItem(1, "Buy groceries", "Buy milk and eggs", new Date(), false, persons.get(0)));
        todoItems.add(new TodoItem(2, "Change tires", "Change car tires before winter", new Date(), false, persons.get(1)));

        // Create a list of todo item tasks
        List<TodoItemTask> todoItemTasks = new ArrayList<>();
        todoItemTasks.add(new TodoItemTask(1, todoItems.get(0), persons.get(1)));
        todoItemTasks.add(new TodoItemTask(2, todoItems.get(1), null));

        // Display the data
        for (Person person : persons) {
            System.out.println(person.toString());
        }

        for (TodoItem todoItem : todoItems) {
            System.out.println(todoItem.toString());
        }

        for (TodoItemTask todoItemTask : todoItemTasks) {
            System.out.println(todoItemTask.toString());
        }

        // Display app user data
        for (AppUser appUser : appUsers) {
            System.out.println(appUser.toString());
        }
    }
}
