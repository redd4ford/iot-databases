package com.redd4ford.steam.view;

import com.redd4ford.steam.controller.impl.AccountController;
import com.redd4ford.steam.controller.impl.AccountProtectedDataController;
import com.redd4ford.steam.controller.impl.CountryController;
import com.redd4ford.steam.controller.impl.GameController;
import com.redd4ford.steam.controller.impl.GenreController;
import com.redd4ford.steam.controller.impl.PublisherController;
import com.redd4ford.steam.model.entity.Account;
import com.redd4ford.steam.model.entity.AccountProtectedData;
import com.redd4ford.steam.model.entity.Country;
import com.redd4ford.steam.model.entity.Game;
import com.redd4ford.steam.model.entity.Genre;
import com.redd4ford.steam.model.entity.Publisher;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class View {

  private static final Scanner SCANNER = new Scanner(System.in, StandardCharsets.UTF_8);
  private final AccountController accountController;
  private final AccountProtectedDataController accountProtectedDataController;
  private final CountryController countryController;
  private final GameController gameController;
  private final GenreController genreController;
  private final PublisherController publisherController;

  private final Map<String, Printable> menu = new LinkedHashMap<>();

  public View() {

    accountController = new AccountController();
    accountProtectedDataController = new AccountProtectedDataController();
    countryController = new CountryController();
    gameController = new GameController();
    genreController = new GenreController();
    publisherController = new PublisherController();

    menu.put("11", this::getAllAccounts);
    menu.put("12", this::getAccountById);
    menu.put("13", this::createAccount);
    menu.put("14", this::updateAccount);
    menu.put("15", this::deleteAccount);
    menu.put("16", this::getAccountsByCountry);

    menu.put("21", this::getAllAccountProtectedData);
    menu.put("22", this::getAccountProtectedDataById);
    menu.put("23", this::createAccountProtectedData);
    menu.put("24", this::updateAccountProtectedData);
    menu.put("25", this::deleteAccountProtectedData);
    menu.put("26", this::getProtectedDataByAccount);

    menu.put("31", this::getAllCountries);
    menu.put("32", this::getCountryById);
    menu.put("33", this::createCountry);
    menu.put("34", this::updateCountry);
    menu.put("35", this::deleteCountry);

    menu.put("41", this::getAllGames);
    menu.put("42", this::getGameById);
    menu.put("43", this::createGame);
    menu.put("44", this::updateGame);
    menu.put("45", this::deleteGame);
    menu.put("46", this::getGamesByPublisher);

    menu.put("51", this::getAllGenres);
    menu.put("52", this::getGenreById);
    menu.put("53", this::createGenre);
    menu.put("54", this::updateGenre);
    menu.put("55", this::deleteGenre);
    menu.put("56", this::getGenresForGames);

    menu.put("61", this::getAllPublishers);
    menu.put("62", this::getPublisherById);
    menu.put("63", this::createPublisher);
    menu.put("64", this::updatePublisher);
    menu.put("65", this::deletePublisher);
    menu.put("66", this::getPublishersByCountry);
  }

  public void displayMenu() {
    System.out.println("=======================================================================");
    System.out.println("                 Enter XY to choose the option, where:");
    System.out.println("=======================================================================");
    System.out.println("X - entity number:                 |       Y - CRUD number:");
    System.out.println("  1 - account *                    |         1 - GET ALL");
    System.out.println("  2 - account protected data       |         2 - GET ONE");
    System.out.println("  3 - country                      |         3 - CREATE");
    System.out.println("  4 - game *                       |         4 - UPDATE");
    System.out.println("  5 - genre *                      |         5 - DELETE");
    System.out.println("  6 - publisher *                  |         6 - GET BY RELATIONS");
    System.out.println("E.G. accounts (X=1) - get all (Y=1): 11");
    System.out.println("     country (X=3) - update (Y=4): 34");
    System.out.println("     game (X=4) - get one (Y=2): 42");
    System.out.println("=======================================================================");
  }

  public final void show() {
    String input;
    displayMenu();
    System.out.println("\nChoose your fighter:\n");
    do {
      try {
        input = SCANNER.next();
        menu.get(input).print();
      } catch (Exception ignored) {
      }
    } while (SCANNER.hasNext());
  }

  private void getAccountsByCountry() {
    System.out.println("\n[ACCOUNTS / COUNTRY] Enter country ID: ");
    Integer id = SCANNER.nextInt();
    System.out.println(countryController.findOne(id));
    System.out.println(accountController.findByCountry(id) + "\n");
  }

  private void getProtectedDataByAccount() {
    System.out.println("\n[ACCOUNT / PROTECTED DATA] Enter account ID: ");
    Integer id = SCANNER.nextInt();
    System.out.println(accountController.findOne(id));
    System.out.println(accountProtectedDataController.findOne(id) + "\n");
  }

  private void getGamesByPublisher() {
    System.out.println("\n[GAMES / PUBLISHER] Enter publisher ID: ");
    Integer id = SCANNER.nextInt();
    System.out.println(publisherController.findOne(id));
    System.out.println(gameController.findByPublisher(id) + "\n");
  }

  private void getPublishersByCountry() {
    System.out.println("\n[PUBLISHERS / COUNTRY] Enter country ID: ");
    Integer id = SCANNER.nextInt();
    System.out.println(countryController.findOne(id));
    System.out.println(publisherController.findByCountry(id) + "\n");
  }



  private void getAllAccounts() {
    System.out.println("\n[ACCOUNT / GET]");
    System.out.println(accountController.findAll() + "\n");
  }

  private void getAccountById() {
    System.out.println("\n[ACCOUNT / GET] Enter ID: ");
    Integer id = SCANNER.nextInt();
    System.out.println(accountController.findOne(id) + "\n");
  }

  private Account getAccountInputs() {
    System.out.println("\nEnter country ID: ");
    Integer countryId = SCANNER.nextInt();
    Country country = countryController.findOne(countryId);
    System.out.println("Enter account name: ");
    String accountName = SCANNER.next();
    System.out.println("Enter level: ");
    Integer level = SCANNER.nextInt();
    System.out.println("Enter online status (1 - online/0 - offline): ");
    int isOnline = SCANNER.nextInt();

    return new Account(0, country, accountName, level, isOnline);
  }

  private void createAccount() {
    System.out.println("\n[ACCOUNT / CREATE]");
    Account account = getAccountInputs();
    accountController.create(account);
    System.out.println("Account successfully created\n");
  }

  private void updateAccount() {
    System.out.println("\n[ACCOUNT / UPDATE] Enter ID: ");
    Integer id = SCANNER.nextInt();
    Account account = getAccountInputs();
    account.setId(id);

    accountController.update(account.getId(), account);
    System.out.println("Account with ID=" + id + " successfully updated\n");
  }

  private void deleteAccount() {
    System.out.println("\n[ACCOUNT / DELETE] Enter ID: ");
    int id = SCANNER.nextInt();

    accountController.delete(id);
    System.out.println("Account with ID=" + id + " successfully deleted\n");
  }



  private void getAllAccountProtectedData() {
    System.out.println("\n[ACCOUNT PROTECTED DATA / GET]");
    System.out.println(accountProtectedDataController.findAll() + "\n");
  }

  private void getAccountProtectedDataById() {
    System.out.println("\n[ACCOUNT PROTECTED DATA / GET] Enter ID: ");
    Integer id = SCANNER.nextInt();
    System.out.println(accountProtectedDataController.findOne(id) + "\n");
  }

  private AccountProtectedData getAccountProtectedDataInputs() {
    System.out.println("Enter account's ID: ");
    Integer id = SCANNER.nextInt();
    System.out.println("Enter password: ");
    String password = SCANNER.next();
    System.out.println("Enter email: ");
    String email = SCANNER.next();

    return new AccountProtectedData(id, password, email);
  }

  private void createAccountProtectedData() {
    System.out.println("\n[ACCOUNT PROTECTED DATA / CREATE]");
    AccountProtectedData accountProtectedData = getAccountProtectedDataInputs();
    accountProtectedDataController.create(accountProtectedData);
    System.out.println("Account's protected data successfully created\n");
  }

  private void updateAccountProtectedData() {
    System.out.println("\n[ACCOUNT PROTECTED DATA / UPDATE]");
    AccountProtectedData accountProtectedData = getAccountProtectedDataInputs();

    accountProtectedDataController.update(accountProtectedData.getAccountId(),
        accountProtectedData);
    System.out.println("Account's protected data with ID=" + accountProtectedData.getAccountId()
        + " successfully updated\n");
  }

  private void deleteAccountProtectedData() {
    System.out.println("\n[ACCOUNT PROTECTED DATA / DELETE] Enter ID: ");
    int id = SCANNER.nextInt();

    accountProtectedDataController.delete(id);
    System.out.println("Account's protected data with ID=" + id + " successfully deleted\n");
  }



  private void getAllCountries() {
    System.out.println("\n[COUNTRY / GET]");
    System.out.println(countryController.findAll() + "\n");
  }

  private void getCountryById() {
    System.out.println("\n[COUNTRY / GET] Enter ID: ");
    Integer id = SCANNER.nextInt();
    System.out.println(countryController.findOne(id) + "\n");
  }

  private Country getCountryInputs() {
    System.out.println("\nEnter country's name: ");
    String name = SCANNER.next();

    return new Country(0, name);
  }

  private void createCountry() {
    System.out.println("\n[COUNTRY / CREATE]");
    Country country = getCountryInputs();
    countryController.create(country);
    System.out.println("Country successfully created\n");
  }

  private void updateCountry() {
    System.out.println("\n[COUNTRY / UPDATE] Enter ID: ");
    Integer id = SCANNER.nextInt();
    Country country = getCountryInputs();
    country.setId(id);

    countryController.update(country.getId(), country);
    System.out.println("Country with ID=" + id + " successfully updated\n");
  }

  private void deleteCountry() {
    System.out.println("\n[COUNTRY / DELETE] Enter ID: ");
    int id = SCANNER.nextInt();

    countryController.delete(id);
    System.out.println("Country with ID=" + id + " successfully deleted\n");
  }



  private void getAllGames() {
    System.out.println("\n[GAME / GET]");
    System.out.println(gameController.findAll() + "\n");
  }

  private void getGameById() {
    System.out.println("\n[GAME / GET] Enter ID: ");
    Integer id = SCANNER.nextInt();
    System.out.println(gameController.findOne(id) + "\n");
  }

  private Game getGameInputs() {
    System.out.println("\nEnter publisher ID: ");
    Integer publisherId = SCANNER.nextInt();
    Publisher publisher = publisherController.findOne(publisherId);
    System.out.println("Enter title: ");
    String title = SCANNER.next();
    System.out.println("Enter rating (0-100): ");
    Integer rating = SCANNER.nextInt();
    System.out.println("Enter release date: ");
    String releaseDate = SCANNER.next();
    System.out.println("Enter price (UAH): ");
    Integer priceInUah = SCANNER.nextInt();

    return new Game(0, publisher, title, rating, releaseDate,
        priceInUah);
  }

  private void createGame() {
    System.out.println("\n[GAME / CREATE]");
    Game game = getGameInputs();
    gameController.create(game);
    System.out.println("Game successfully created\n");
  }

  private void updateGame() {
    System.out.println("\n[GAME / UPDATE] Enter ID: ");
    Integer id = SCANNER.nextInt();
    Game game = getGameInputs();
    game.setId(id);

    gameController.update(game.getId(), game);
    System.out.println("Game with ID=" + id + " successfully updated\n");
  }

  private void deleteGame() {
    System.out.println("\n[GAME / DELETE] Enter ID: ");
    int id = SCANNER.nextInt();

    gameController.delete(id);
    System.out.println("Game with ID=" + id + " successfully deleted\n");
  }



  private void getAllGenres() {
    System.out.println("\n[GENRE / GET]");
    System.out.println(genreController.findAll() + "\n");
  }

  private void getGenreById() {
    System.out.println("\n[GENRE / GET] Enter ID: ");
    Integer id = SCANNER.nextInt();
    System.out.println(genreController.findOne(id) + "\n");
  }

  private Genre getGenreInputs() {
    System.out.println("\nEnter name: ");
    String name = SCANNER.next();

    return new Genre(0, name);
  }

  private void createGenre() {
    System.out.println("\n[GENRE / CREATE]");
    Genre genre = getGenreInputs();
    genreController.create(genre);
    System.out.println("Genre successfully created\n");
  }

  private void updateGenre() {
    System.out.println("\n[GENRE / UPDATE] Enter ID: ");
    Integer id = SCANNER.nextInt();
    Genre genre = getGenreInputs();
    genre.setId(id);

    genreController.update(genre.getId(), genre);
    System.out.println("Genre with ID=" + id + " successfully updated\n");
  }

  private void deleteGenre() {
    System.out.println("\n[GENRE / DELETE] Enter ID: ");
    int id = SCANNER.nextInt();

    genreController.delete(id);
    System.out.println("Genre with ID=" + id + " successfully deleted\n");
  }

  private void getGenresForGames() {
    gameController.findGenres();
  }



  private void getAllPublishers() {
    System.out.println("\n[PUBLISHER / GET]");
    System.out.println(publisherController.findAll() + "\n");
  }

  private void getPublisherById() {
    System.out.println("\n[PUBLISHER / GET] Enter ID: ");
    Integer id = SCANNER.nextInt();
    System.out.println(publisherController.findOne(id) + "\n");
  }

  private Publisher getPublisherInputs() {
    System.out.println("\nEnter name: ");
    String name = SCANNER.next();
    System.out.println("\nEnter country ID: ");
    Integer countryId = SCANNER.nextInt();
    Country country = countryController.findOne(countryId);

    return new Publisher(0, name, country);
  }

  private void createPublisher() {
    System.out.println("[PUBLISHER / CREATE]");
    Publisher publisher = getPublisherInputs();
    publisherController.create(publisher);
    System.out.println("Publisher successfully created\n");
  }

  private void updatePublisher() {
    System.out.println("\n[PUBLISHER / UPDATE] Enter ID: ");
    Integer id = SCANNER.nextInt();
    Publisher publisher = getPublisherInputs();
    publisher.setId(id);

    publisherController.update(publisher.getId(), publisher);
    System.out.println("Publisher with ID=" + id + " successfully updated\n");
  }

  private void deletePublisher() {
    System.out.println("\n[PUBLISHER / DELETE] Enter ID: ");
    int id = SCANNER.nextInt();

    publisherController.delete(id);
    System.out.println("Publisher with ID=" + id + " successfully deleted\n");
  }

}
