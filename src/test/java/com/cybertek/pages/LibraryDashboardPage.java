package com.cybertek.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LibraryDashboardPage extends BasePage{
    @FindBy(id = "borrowed_books")
    public WebElement borrowedBooksNumber;

    @FindBy(id = "user_count")
    public WebElement usersNumber;

    @FindBy(id = "book_count")
    public WebElement booksNumber;
    @FindBy (id = "user_avatar")
    public WebElement userAvatar;
}
