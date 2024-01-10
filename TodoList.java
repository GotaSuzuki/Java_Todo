import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

class Todo {
  String randomId;
  String task;
  int priority;
}

public class TodoList {
  Map<String, Todo> tasks = new LinkedHashMap<>();

  // 追加機能
  public void addItem(String task, int priority) {
    Todo todo = new Todo();
    UUID uuid = UUID.randomUUID();
    todo.randomId = uuid.toString();
    todo.task = task;
    todo.priority = priority;
    // tasks.put(key, value)を示している
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
  public void displayItem() {
    System.out.println("------------------------------");
    System.out.println("TodoList:");
    
    printContent(tasks);
  }
  
  // ソートした表示機能
  public void sortByPriority() {
    System.out.println("------------------------------");
    System.out.println("SortedTodoList:");
    // tasksからsortedMapに配列を作成 TreeMapで昇順 Collections.reverseOrder()で降順にしている
    TreeMap<Integer, Todo> sortedMap = new TreeMap<>(Collections.reverseOrder());
    for (Todo todo : tasks.values()) {
      sortedMap.put(todo.priority, todo);
    }
    
    printContent(sortedMap);
  }
  
  // 表示内容
  private final int INDEX_START = 1;
  public <K,V> void printContent(Map<K,V> map){
    int index = INDEX_START;
    for(Map.Entry<K,V> entry: map.entrySet()){
      Todo todo = (Todo)entry.getValue();

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
