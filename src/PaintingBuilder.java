import java.util.Scanner;

public class PaintingBuilder {

    private Painting[] paintings = new Painting[3];
    private int index = 0;

    public void buildPainting(){
        if (index == paintings.length){
            System.out.println("There is too much paintings.");
            for (int i = 0; i < paintings.length; i++){
                System.out.println(paintings[i].toString());
            }
            System.exit(0);
        }else {
            paintings[index] = uniqueBuilder();
            index++;
        }
    }

    private Painting uniqueBuilder(){
        boolean flag = true;
        Painting newPainting = null;
        while (flag){
            newPainting = builder();
            if (isPaintingunique(newPainting)){
                flag = false;
            }else {
                System.out.println("This painting isn't unique.");
            }
        }
        return newPainting;
    }


    public static Painting builder() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the painting title: ");
        String title = scanner.nextLine();
        System.out.println("Enter the painting author: ");
        String author = scanner.nextLine();
        System.out.println("Enter the year of painting: ");
        int year = scanner.nextInt();

        return new Painting(title, author, year);

    }

    private boolean isPaintingunique(Painting painting){
        boolean unique = true;
        for (int i = 0; i < paintings.length; i++){
            if(painting.equals(paintings[i])){
                unique = false;
                break;
            }
        }
        return unique;
    }

}