class Person {
    String name;
    int age;
}

class MakingChanges {
    public static void changeIdentities(Person p1, Person p2) {
    if(p1 != null && p2 != null){
        String tmpName = p2.name;
        int tmpAge = p2.age;
        p2.age = p1.age;
        p2.name = p1.name;
        p1.age = tmpAge;
        p1.name = tmpName;

    }
    }
}