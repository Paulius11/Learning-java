package dictionary;

public class Main {
    public static void main(String[] args) {
    MultipleEntryDictionary dict = new PersonalMultipleEntryDictionary();
    dict.add("kuussi", "six");
    dict.add("kuussi", "spruce");

    dict.add("pii", "silicon");
    dict.add("pii", "pi");
    
    System.out.println(dict.translate("kuussi"));
    dict.remove("pii");
    System.out.println(dict.translate("pii"));
    }
}
