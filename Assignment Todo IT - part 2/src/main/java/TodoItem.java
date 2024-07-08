import java.util.Date;

public class TodoItem {
    private int id;
    private String title;
    private String description;
    private Date deadLine;
    private boolean done;
    private Person creator;

    public TodoItem(int id, String title, String description, Date deadLine, boolean done, Person creator) {
        if (title == null || title.isEmpty() || deadLine == null) {
            throw new IllegalArgumentException("Title and deadline cannot be null");
        }
        this.id = id;
        this.title = title;
        this.description = description;
        this.deadLine = deadLine;
        this.done = done;
        this.creator = creator;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty");
        }
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(Date deadLine) {
        if (deadLine == null) {
            throw new IllegalArgumentException("Deadline cannot be null");
        }
        this.deadLine = deadLine;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Person getCreator() {
        return creator;
    }

    public void setCreator(Person creator) {
        this.creator = creator;
    }

    @Override
    public String toString() {
        return "TodoItem{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", deadLine=" + deadLine +
                ", done=" + done +
                '}';
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + title.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + deadLine.hashCode();
        result = 31 * result + (done ? 1 : 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TodoItem todoItem = (TodoItem) o;

        if (id != todoItem.id) return false;
        if (done != todoItem.done) return false;
        if (!title.equals(todoItem.title)) return false;
        if (!description.equals(todoItem.description)) return false;
        return deadLine.equals(todoItem.deadLine);
    }

    public boolean isOverdue() {
        return new Date().after(deadLine);
    }
}
