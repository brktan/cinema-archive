import com.buraktan.app.core.dao.CategoryDao;
import com.buraktan.app.core.dao.MovieDao;
import com.buraktan.app.core.domain.Category;
import com.buraktan.app.core.domain.Movie;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        menu();

        while (!exit) {
            int choice = scanner.nextInt();
            CategoryDao categoryDao = new CategoryDao();

            switch (choice) {

                case 0:
                    menu();
                    break;

                case 1:
                    listCategories();
                    System.out.println("-----------------------\n"
                            + "To Continue:0\n"
                            + "to Exit:7");
                    break;

                case 2:
                    Scanner scan2 = new Scanner(System.in);
                    String c;
                    System.out.println("Add to Category Name:");
                    c = scan2.next();
                    Category category = new Category();
                    category.setName(c);
                    addCategory(category);
                    System.out.println("-----------------------\n"
                            + "To Continue:0\n"
                            + "to Exit:7");
                    break;

                case 3:
                    listCategories();
                    Scanner scan = new Scanner(System.in);
                    Long b;
                    System.out.println("Delete to Category Id:");
                    b = scan.nextLong();

                    Category category2 = categoryDao.findCategoryById(b);
                    deleteCategory(category2);
                    System.out.println("-----------------------\n"
                            + "To Continue:0\n"
                            + "to Exit:7");
                    break;

                case 4:
                    listCategories();
                    Scanner scanner3 = new Scanner(System.in);
                    Long d;
                    System.out.println("Delete to Category Id:");
                    d = scanner3.nextLong();
                    Category category3 = categoryDao.findCategoryById(d);
                    List<Movie> movieList = listMovie(category3);
                    for (Movie movie : movieList) {
                        System.out.println(movie);
                    }
                    System.out.println("-----------------------\n"
                            + "To Continue:0\n"
                            + "to Exit:7");
                    break;

                case 5:
                    searchMovie();
                    System.out.println("-----------------------\n"
                            + "To Continue:0\n"
                            + "to Exit:7");
                    break;

                case 6:
                    getMovieDetail();
                    System.out.println("-----------------------\n"
                            + "To Continue:0\n"
                            + "to Exit:7");
                    break;

                case 7:
                    exit = true;
                    System.out.println("Thanks For Viewing My Archive");
                    System.out.println("EXIT...");
                    break;
                default:
                    System.out.println("WRONG CHOICE...");
                    System.out.println("-----------------------\n"
                            + "To Continue:0\n"
                            + "to Exit:7");
                    break;
            }
        }
    }

    public static void menu() {
        String mainMenu = ("--------------------------\n"
                + "0. Menu List\n"
                + "1. Category List\n"
                + "2. Add to Category\n"
                + "3. Delete to Category\n"
                + "4. Movie List\n"
                + "5. Search Movie\n"
                + "6. Movie's Details\n"
                + "7. Exit..\n"
                + "Select a choice from the menu: ");

        System.out.println(mainMenu);
    }


    public static List listCategories() {
        List<Category> categoryList;
        CategoryDao categoryDao = new CategoryDao();
        categoryList = categoryDao.findAllCategories();
        System.out.println("--------------------------\n" + "Category List:");
        for (Category category : categoryList) {
            System.out.println(category);
        }
        return null;
    }

    public static void addCategory(Category category) {
        CategoryDao categoryDao = new CategoryDao();
        categoryDao.saveCategory(category);

    }

    public static void deleteCategory(Category category) {

        CategoryDao categoryDao = new CategoryDao();
        categoryDao.deleteCategory(category.getId());
    }

    public static List<Movie> listMovie(Category category) {
        MovieDao movieDao = new MovieDao();
        List<Movie> movieList = new ArrayList<>();
        movieList = movieDao.findMovieByCategoryId(category.getId());
        return movieList;


    }


    public static List searchMovie() {
        Scanner scan = new Scanner(System.in);
        List<Movie> movieList = new ArrayList<Movie>();
        String m;
        List<String> a = new ArrayList<String>();
        System.out.println("Movie's Name:");
        m = scan.nextLine();
        a.add(m);

        MovieDao movieDao = new MovieDao();
        movieList = (List<Movie>) movieDao.findMovieByName(m);
        for (Movie movie : movieList) {
            System.out.println("--------------------------\n" + movie);
        }
        return null;
    }

    public static void getMovieDetail() {
        Scanner scan = new Scanner(System.in);
        long m;
        System.out.println("Movie's Details Id:");
        m = scan.nextLong();

        MovieDao movieDao = new MovieDao();
        Movie movie = movieDao.findMovieById(m);
        System.out.println("--------------------------\n" + movie);
    }

}
