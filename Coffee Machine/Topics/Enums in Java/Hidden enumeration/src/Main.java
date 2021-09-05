
public class Main {

    public static void main(String[] args) {
        int count = 0;
        for (Secret status : Secret.values()){
            if (status.toString().contains("STAR"))
            // System.out.println(status);
            count++;
        }
        System.out.print(count);
    }

// enum Secret {
//     STAR, CRASH, START
// }
}