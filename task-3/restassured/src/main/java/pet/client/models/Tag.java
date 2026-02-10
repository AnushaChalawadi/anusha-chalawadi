package pet.client.models;

public class Tag {
  private long id;
  private String name;

  // Constructor
  public Tag(long id, String name) {
    this.id = id;
    this.name = name;
  }

  // Getter Method
  public long getId() {
    return id;
  }

  // Setter Method
  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}