package com.redd4ford.steam.view;

import com.redd4ford.steam.controller.impl.AccountController;
import com.redd4ford.steam.controller.impl.AccountProtectedDataController;
import com.redd4ford.steam.controller.impl.CountryController;
import com.redd4ford.steam.controller.impl.GameController;
import com.redd4ford.steam.controller.impl.GenreController;
import com.redd4ford.steam.controller.impl.PlatformController;
import com.redd4ford.steam.controller.impl.PublisherController;
import com.redd4ford.steam.controller.impl.SupportedBrowserController;
import com.redd4ford.steam.model.entity.Account;
import com.redd4ford.steam.model.entity.AccountProtectedData;
import com.redd4ford.steam.model.entity.Country;
import com.redd4ford.steam.model.entity.Game;
import com.redd4ford.steam.model.entity.Genre;
import com.redd4ford.steam.model.entity.Platform;
import com.redd4ford.steam.model.entity.Publisher;
import com.redd4ford.steam.model.entity.SupportedBrowser;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class View {

  private static final Scanner SCANNER = new Scanner(System.in);
  private final AccountController accountController = new AccountController();
  private final AccountProtectedDataController accountProtectedDataController =
      new AccountProtectedDataController();
  private final CountryController countryController = new CountryController();
  private final GameController gameController = new GameController();
  private final GenreController genreController = new GenreController();
  private final PlatformController platformController = new PlatformController();
  private final PublisherController publisherController = new PublisherController();
  private final SupportedBrowserController supportedBrowserController =
      new SupportedBrowserController();

  private final Map<String, Printable> menu = new LinkedHashMap<>();


  public View() {

    menu.put("11", this::getAllAccounts);
    menu.put("12", this::getAccountById);
    menu.put("13", this::createAccount);
    menu.put("14", this::updateAccount);
    menu.put("15", this::deleteAccount);

    menu.put("21", this::getAllAccountProtectedData);
    menu.put("22", this::getAccountProtectedDataById);
    menu.put("23", this::createAccountProtectedData);
    menu.put("24", this::updateAccountProtectedData);
    menu.put("25", this::deleteAccountProtectedData);

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

    menu.put("51", this::getAllGenres);
    menu.put("52", this::getGenreById);
    menu.put("53", this::createGenre);
    menu.put("54", this::updateGenre);
    menu.put("55", this::deleteGenre);

    menu.put("61", this::getAllPlatforms);
    menu.put("62", this::getPlatformById);
    menu.put("63", this::createPlatform);
    menu.put("64", this::updatePlatform);
    menu.put("65", this::deletePlatform);

    menu.put("71", this::getAllPublishers);
    menu.put("72", this::getPublisherById);
    menu.put("73", this::createPublisher);
    menu.put("74", this::updatePublisher);
    menu.put("75", this::deletePublisher);

    menu.put("81", this::getAllSupportedBrowsers);
    menu.put("82", this::getSupportedBrowserById);
    menu.put("83", this::createSupportedBrowser);
    menu.put("84", this::updateSupportedBrowser);
    menu.put("85", this::deleteSupportedBrowser);
  }

  public void displayMenu() {
    System.out.println("=======================================================================");
    System.out.println("                 Enter XY to choose the option, where:");
    System.out.println("=======================================================================");
    System.out.println("X - entity number:                 |       Y - CRUD number:");
    System.out.println("  1 - account                      |         1 - GET ALL");
    System.out.println("  2 - account protected data       |         2 - GET ONE");
    System.out.println("  3 - country                      |         3 - CREATE");
    System.out.println("  4 - game                         |         4 - UPDATE");
    System.out.println("  5 - genre                        |         5 - DELETE");
    System.out.println("  6 - platform");
    System.out.println("  7 - publisher");
    System.out.println("  8 - supported browser");
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

  private void getAllAccounts() throws SQLException {
    System.out.println("\n[ACCOUNT / GET]");
    System.out.println(accountController.findAll() + "\n");
  }

  private void getAccountById() throws SQLException {
    System.out.println("\n[ACCOUNT / GET] Enter ID: ");
    Integer id = SCANNER.nextInt();
    System.out.println(accountController.findOne(id) + "\n");
  }

  private Account getAccountInputs() {
    System.out.println("\nEnter country ID: ");
    Integer countryId = SCANNER.nextInt();
    System.out.println("Enter account name: ");
    String accountName = SCANNER.next();
    System.out.println("Enter level: ");
    Integer level = SCANNER.nextInt();
    System.out.println("Enter online status (1 - online/0 - offline): ");
    int isOnline = SCANNER.nextInt();
    if (isOnline != 1) {
      isOnline = 0;
    }

    return new Account(countryId, accountName, level, isOnline);
  }

  private void createAccount() throws SQLException {
    System.out.println("\n[ACCOUNT / CREATE]");
    Account account = getAccountInputs();
    accountController.create(account);
    System.out.println("Account successfully created\n");
  }

  private void updateAccount() throws SQLException {
    System.out.println("\n[ACCOUNT / UPDATE] Enter ID: ");
    Integer id = SCANNER.nextInt();
    Account account = getAccountInputs();
    account.setId(id);

    accountController.update(account.getId(), account);
    System.out.println("Account with ID=" + id + " successfully updated\n");
  }

  private void deleteAccount() throws SQLException {
    System.out.println("\n[ACCOUNT / DELETE] Enter ID: ");
    int id = SCANNER.nextInt();

    accountController.delete(id);
    System.out.println("Account with ID=" + id + " successfully deleted\n");
  }


  private void getAllAccountProtectedData() throws SQLException {
    System.out.println("\n[ACCOUNT PROTECTED DATA / GET]");
    System.out.println(accountProtectedDataController.findAll() + "\n");
  }

  private void getAccountProtectedDataById() throws SQLException {
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

  private void createAccountProtectedData() throws SQLException {
    System.out.println("\n[ACCOUNT PROTECTED DATA / CREATE]");
    AccountProtectedData accountProtectedData = getAccountProtectedDataInputs();
    accountProtectedDataController.create(accountProtectedData);
    System.out.println("Account's protected data successfully created\n");
  }

  private void updateAccountProtectedData() throws SQLException {
    System.out.println("\n[ACCOUNT PROTECTED DATA / UPDATE]");
    AccountProtectedData accountProtectedData = getAccountProtectedDataInputs();

    accountProtectedDataController.update(accountProtectedData.getAccountId(),
        accountProtectedData);
    System.out.println("Account's protected data with ID=" + accountProtectedData.getAccountId()
        + " successfully updated\n");
  }

  private void deleteAccountProtectedData() throws SQLException {
    System.out.println("\n[ACCOUNT PROTECTED DATA / DELETE] Enter ID: ");
    int id = SCANNER.nextInt();

    accountProtectedDataController.delete(id);
    System.out.println("Account's protected data with ID=" + id + " successfully deleted\n");
  }


  private void getAllCountries() throws SQLException {
    System.out.println("\n[COUNTRY / GET]");
    System.out.println(countryController.findAll() + "\n");
  }

  private void getCountryById() throws SQLException {
    System.out.println("\n[COUNTRY / GET] Enter ID: ");
    Integer id = SCANNER.nextInt();
    System.out.println(countryController.findOne(id) + "\n");
  }

  private Country getCountryInputs() {
    System.out.println("\nEnter country's name: ");
    String name = SCANNER.nextLine();

    return new Country(name);
  }

  private void createCountry() throws SQLException {
    System.out.println("\n[COUNTRY / CREATE]");
    Country country = getCountryInputs();
    countryController.create(country);
    System.out.println("Country successfully created\n");
  }

  private void updateCountry() throws SQLException {
    System.out.println("\n[COUNTRY / UPDATE] Enter ID: ");
    Integer id = SCANNER.nextInt();
    Country country = getCountryInputs();
    country.setId(id);

    countryController.update(country.getId(), country);
    System.out.println("Country with ID=" + id + " successfully updated\n");
  }

  private void deleteCountry() throws SQLException {
    System.out.println("\n[COUNTRY / DELETE] Enter ID: ");
    int id = SCANNER.nextInt();

    countryController.delete(id);
    System.out.println("Country with ID=" + id + " successfully deleted\n");
  }


  private void getAllGames() throws SQLException {
    System.out.println("\n[GAME / GET]");
    System.out.println(gameController.findAll() + "\n");
  }

  private void getGameById() throws SQLException {
    System.out.println("\n[GAME / GET] Enter ID: ");
    Integer id = SCANNER.nextInt();
    System.out.println(gameController.findOne(id) + "\n");
  }

  private Game getGameInputs() {
    System.out.println("\nEnter publisher ID: ");
    Integer publisherId = SCANNER.nextInt();
    System.out.println("Enter title: ");
    String title = SCANNER.next();
    System.out.println("Enter rating (0-100): ");
    Integer rating = SCANNER.nextInt();
    System.out.println("Enter release date: ");
    String releaseDate = SCANNER.next();
    System.out.println("Enter price (UAH): ");
    Integer priceInUah = SCANNER.nextInt();

    return new Game(-1, publisherId, title, rating, releaseDate, priceInUah);
  }

  private void createGame() throws SQLException {
    System.out.println("\n[GAME / CREATE]");
    Game game = getGameInputs();
    gameController.create(game);
    System.out.println("Game successfully created\n");
  }

  private void updateGame() throws SQLException {
    System.out.println("\n[GAME / UPDATE] Enter ID: ");
    Integer id = SCANNER.nextInt();
    Game game = getGameInputs();
    game.setId(id);

    gameController.update(game.getId(), game);
    System.out.println("Game with ID=" + id + " successfully updated\n");
  }

  private void deleteGame() throws SQLException {
    System.out.println("\n[GAME / DELETE] Enter ID: ");
    int id = SCANNER.nextInt();

    gameController.delete(id);
    System.out.println("Game with ID=" + id + " successfully deleted\n");
  }


  private void getAllGenres() throws SQLException {
    System.out.println("\n[GENRE / GET]");
    System.out.println(genreController.findAll() + "\n");
  }

  private void getGenreById() throws SQLException {
    System.out.println("\n[GENRE / GET] Enter ID: ");
    Integer id = SCANNER.nextInt();
    System.out.println(genreController.findOne(id) + "\n");
  }

  private Genre getGenreInputs() {
    System.out.println("\nEnter name: ");
    String name = SCANNER.next();

    return new Genre(-1, name);
  }

  private void createGenre() throws SQLException {
    System.out.println("\n[GENRE / CREATE]");
    Genre genre = getGenreInputs();
    genreController.create(genre);
    System.out.println("Genre successfully created\n");
  }

  private void updateGenre() throws SQLException {
    System.out.println("\n[GENRE / UPDATE] Enter ID: ");
    Integer id = SCANNER.nextInt();
    Genre genre = getGenreInputs();
    genre.setId(id);

    genreController.update(genre.getId(), genre);
    System.out.println("Genre with ID=" + id + " successfully updated\n");
  }

  private void deleteGenre() throws SQLException {
    System.out.println("\n[GENRE / DELETE] Enter ID: ");
    int id = SCANNER.nextInt();

    genreController.delete(id);
    System.out.println("Genre with ID=" + id + " successfully deleted\n");
  }


  private void getAllPlatforms() throws SQLException {
    System.out.println("\n[PLATFORM / GET]");
    System.out.println(platformController.findAll() + "\n");
  }

  private void getPlatformById() throws SQLException {
    System.out.println("\n[PLATFORM / GET] Enter ID: ");
    Integer id = SCANNER.nextInt();
    System.out.println(platformController.findOne(id) + "\n");
  }

  private Platform getPlatformInputs() {
    System.out.println("\nEnter name: ");
    String name = SCANNER.next();

    return new Platform(-1, name);
  }

  private void createPlatform() throws SQLException {
    System.out.println("[PLATFORM / CREATE]");
    Platform platform = getPlatformInputs();
    platformController.create(platform);
    System.out.println("Platform successfully created\n");
  }

  private void updatePlatform() throws SQLException {
    System.out.println("\n[PLATFORM / UPDATE] Enter ID: ");
    Integer id = SCANNER.nextInt();
    Platform platform = getPlatformInputs();
    platform.setId(id);

    platformController.update(platform.getId(), platform);
    System.out.println("Platform with ID=" + id + " successfully updated\n");
  }

  private void deletePlatform() throws SQLException {
    System.out.println("\n[PLATFORM / DELETE] Enter ID: ");
    int id = SCANNER.nextInt();

    platformController.delete(id);
    System.out.println("Platform with ID=" + id + " successfully deleted\n");
  }


  private void getAllPublishers() throws SQLException {
    System.out.println("\n[PUBLISHER / GET]");
    System.out.println(publisherController.findAll() + "\n");
  }

  private void getPublisherById() throws SQLException {
    System.out.println("\n[PUBLISHER / GET] Enter ID: ");
    Integer id = SCANNER.nextInt();
    System.out.println(publisherController.findOne(id) + "\n");
  }

  private Publisher getPublisherInputs() {
    System.out.println("\nEnter name: ");
    String name = SCANNER.next();
    System.out.println("\nEnter country ID: ");
    Integer countryId = SCANNER.nextInt();

    return new Publisher(-1, name, countryId);
  }

  private void createPublisher() throws SQLException {
    System.out.println("[PUBLISHER / CREATE]");
    Publisher publisher = getPublisherInputs();
    publisherController.create(publisher);
    System.out.println("Publisher successfully created\n");
  }

  private void updatePublisher() throws SQLException {
    System.out.println("\n[PUBLISHER / UPDATE] Enter ID: ");
    Integer id = SCANNER.nextInt();
    Publisher publisher = getPublisherInputs();
    publisher.setId(id);

    publisherController.update(publisher.getId(), publisher);
    System.out.println("Publisher with ID=" + id + " successfully updated\n");
  }

  private void deletePublisher() throws SQLException {
    System.out.println("\n[PUBLISHER / DELETE] Enter ID: ");
    int id = SCANNER.nextInt();

    publisherController.delete(id);
    System.out.println("Publisher with ID=" + id + " successfully deleted\n");
  }


  private void getAllSupportedBrowsers() throws SQLException {
    System.out.println("\n[SUPPORTED BROWSER / GET]");
    System.out.println(supportedBrowserController.findAll() + "\n");
  }

  private void getSupportedBrowserById() throws SQLException {
    System.out.println("\n[SUPPORTED BROWSER / GET] Enter ID: ");
    Integer id = SCANNER.nextInt();
    System.out.println(supportedBrowserController.findOne(id) + "\n");
  }

  private SupportedBrowser getSupportedBrowserInputs() {
    System.out.println("Enter name: ");
    String name = SCANNER.next();
    System.out.println("Enter version: ");
    String version = SCANNER.next();

    return new SupportedBrowser(name, version);
  }

  private void createSupportedBrowser() throws SQLException {
    System.out.println("[SUPPORTED BROWSER / CREATE]");
    SupportedBrowser supportedBrowser = getSupportedBrowserInputs();
    supportedBrowserController.create(supportedBrowser);
    System.out.println("Supported browser successfully created\n");
  }

  private void updateSupportedBrowser() throws SQLException {
    System.out.println("\n[SUPPORTED BROWSER / UPDATE] Enter ID: ");
    Integer id = SCANNER.nextInt();
    SupportedBrowser supportedBrowser = getSupportedBrowserInputs();
    supportedBrowser.setId(id);

    supportedBrowserController.update(supportedBrowser.getId(), supportedBrowser);
    System.out.println("Supported browser with ID=" + id + " successfully updated\n");
  }

  private void deleteSupportedBrowser() throws SQLException {
    System.out.println("\n[SUPPORTED BROWSER / DELETE] Enter ID: ");
    int id = SCANNER.nextInt();

    supportedBrowserController.delete(id);
    System.out.println("Supported browser with ID=" + id + " successfully deleted\n");
  }

}
