package builder;

class PersonForBuilder {
  public String name;
  public String position;

  @Override
  public String toString() {
    return "Person{" +
        "name='" + name + '\'' +
        ", position='" + position + '\'' +
        '}';
  }
}

class PersonBuilderFluentInterface<SELF extends PersonBuilderFluentInterface<SELF>> {
  protected PersonForBuilder personForBuilder = new PersonForBuilder();

  public SELF withName(String name) {
    personForBuilder.name = name;
    return self();
  }

  public PersonForBuilder build() {
    return personForBuilder;
  }

  protected SELF self() {
    return (SELF) this;
  }
}

class EmployeeBuilderFluentInterface extends PersonBuilderFluentInterface<EmployeeBuilderFluentInterface> {
  public EmployeeBuilderFluentInterface worksAt(String position) {
    personForBuilder.position = position;
    return self();
  }

  @Override
  protected EmployeeBuilderFluentInterface self() {
    return this;
  }
}

class DemoFluentInterface {
  public static void main(String[] args) {
//    PersonBuilder pb = new PersonBuilder();
//    Person itay = pb
//        .withName("Itay")
//        .worksAt
//        .build();
    EmployeeBuilderFluentInterface pb = new EmployeeBuilderFluentInterface();
    PersonForBuilder itay = pb
        .withName("Itay")
        .worksAt("Developer")
        .build();

    System.out.println(itay);
  }
}
