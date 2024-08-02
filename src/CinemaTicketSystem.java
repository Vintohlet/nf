import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CinemaTicketSystem {
    private List<Movie> Movies;
    private List<Ticket> Tickets;
    private int TicketId = 1;

    public CinemaTicketSystem() {
        Movies = new ArrayList<>();
        Tickets = new ArrayList<>();
    }

    public class User {
        int id;
        String name;
        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    public class Movie {
        int id;
        String name;
        public Movie(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    public class Ticket {
        int id;
        String UserName;
        String MovieName;
        public Ticket(int id, String userName, String movieName) {
            this.id = id;
            this.UserName = userName;
            this.MovieName = movieName;
        }
    }

    public void AddMovie(int id, String name) {
        Movie movie = new Movie(id, name);
        Movies.add(movie);
    }

    public void AddUser(int id, String name) {
        User user = new User(id, name);
    }

    public void AddTicket(String userName, String movieName) {
        Ticket ticket = new Ticket(TicketId++, userName, movieName);
        Tickets.add(ticket);
    }

    public boolean RemoveTicket(int ticketId) {
        for (int i = 0; i < Tickets.size(); i++) {
            if (Tickets.get(i).id == ticketId) {
                Tickets.remove(i);
                return true;
            }
        }
        return false;
    }

    public List<Movie> getMovies() {
        return Movies;
    }

    public List<Ticket> getTickets() {
        return Tickets;
    }
    public static void main(String[] args) {
        CinemaTicketSystem cinemaTicketSystem = new CinemaTicketSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Здравствуйте, у вас есть следующие доступные функции:\n" +
                    "\n" +
                    "1. Добавить новый фильм;\n" +
                    "2. Показать все доступные фильмы;\n" +
                    "3. Добавить нового пользователя;\n" +
                    "4. Купить билет;\n" +
                    "5. Посмотреть все билеты;\n" +
                    "6. Отменить покупку билета;");
            int userInput = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over
            switch (userInput) {
                case 1:
                    System.out.println("Введите id для фильма : ");
                    int MovieId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.println("Введите название фильма: ");
                    String MovieName = scanner.nextLine();
                    cinemaTicketSystem.AddMovie(MovieId, MovieName);
                    System.out.println("Вы успешно добавили фильм!");
                    break;
                case 2:
                    System.out.println("Доступные фильмы: ");
                    for (CinemaTicketSystem.Movie movie : cinemaTicketSystem.getMovies()) {
                        System.out.println(movie.name);
                    }
                    break;
                case 3:
                    System.out.println("Введите id пользователя: ");
                    int UserId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.println("Введите имя пользователя: ");
                    String UserName = scanner.nextLine();
                    cinemaTicketSystem.AddUser(UserId, UserName);
                    System.out.println("Вы успешно добавили пользователя!");
                    break;
                case 4:
                    System.out.println("Введите имя пользователя: ");
                    String UserNameBuy = scanner.nextLine();
                    System.out.println("Введите название фильма: ");
                    String MovieNameBuy = scanner.nextLine();
                    cinemaTicketSystem.AddTicket(UserNameBuy, MovieNameBuy);
                    System.out.println("Вы успешно добавили билет!");
                    break;
                case 5:
                    System.out.println("Купленные билеты: ");
                    for (CinemaTicketSystem.Ticket ticket : cinemaTicketSystem.getTickets()) {
                        System.out.println("id: " + ticket.id + " Фильм: " + ticket.MovieName + " Пользователь: " + ticket.UserName);
                    }
                    break;
                case 6:
                    System.out.println("Введите id билета: ");
                    int TicketRemoveId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    if (cinemaTicketSystem.RemoveTicket(TicketRemoveId)) {
                        System.out.println("Билет успешно удален!");
                    } else {
                        System.out.println("Произошла ошибка в удалении");
                    }
                    break;
            }
        }
    }
}