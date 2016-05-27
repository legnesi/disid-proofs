package proof;

public class FieldItem {
  
  private String id;
  private String name;
  private String type;

  public FieldItem(String id, String name, String type) {
    this.setId(id);
    this.setName(name);
    this.setType(type);
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Object getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }




}
