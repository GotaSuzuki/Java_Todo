import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

class Todo {
  String randomId;
  String task;
  int priority;
}

public class TodoList {
  Map<String, Todo> tasks = new HashMap<>();
  Todo todo = new Todo();

  // 追加機能
  public void addItem(String task, int priority) {
    UUID uuid = UUID.randomUUID();
    Todo todo = new Todo();
    todo.randomId = uuid.toString();
    todo.task = task;
    todo.priority = priority;
    tasks.put(todo.randomId, todo);
  }

  // 削除機能
  public void removeItem(String key) {
    if (tasks.containsKey(key)) {
      tasks.remove(key);
    } else {
      System.out.println("無効なキーです");
    }
  }

  // 表示機能
  private final int INDEX_START = 1;
  public void displayItem() {
    int index = INDEX_START;
    System.out.println("------------------------------");
    System.out.println("TodoList:");
    for (Map.Entry<String, Todo> entry : tasks.entrySet()) {
      Todo todo = entry.getValue();

      System.out.println(index + "番目");
      System.out.print("ID:");
      System.out.println(todo.randomId);
      System.out.print("タスク:");
      System.out.println(todo.task);
      System.out.print("優先度:");
      System.out.println(todo.priority);
      index++;
    }
  }
}
