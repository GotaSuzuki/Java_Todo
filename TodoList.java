import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

public class TodoList {
  LinkedHashMap<String, String> tasks = new LinkedHashMap<>();

  // 追加機能
  public void addItem(String task) {
    UUID uuid = UUID.randomUUID();
    String randomId = uuid.toString();
    tasks.put(randomId, task);
  }

  // 削除機能
  public void removeItem(String key){
    if(tasks.containsKey(key)){
      tasks.remove(key);
    }else{
      System.out.println("無効なキーです");
    }
  }

  // 表示機能
  private final int INDEX_START = 1;
  public void displayItem() {
    int index = INDEX_START;
    System.out.println("------------------------------");
    System.out.println("TodoList:");
    for (Map.Entry<String, String> entry : tasks.entrySet()) {
      String key = entry.getKey();
      String value = entry.getValue();
      System.out.println(index + "." + value + ",UUID:" + key);
      index++;
    }
  }
}
