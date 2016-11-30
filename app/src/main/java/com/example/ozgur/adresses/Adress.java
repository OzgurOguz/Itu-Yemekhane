package com.example.ozgur.itu_yemekhane.adresses;

/**
 * Created by ozgur on 16.11.2016.
 */

public interface Adress {
    String mainActivityMealsWebSite = "http://www.sks.itu.edu.tr/index.php?option=com_content&view=article&id=154:aylk-yemek-menuesue&catid=28";
    String mainActivityDateMealsHtml = ".mod_events_latest_date";
    String mainActivityMealsHtml = ".mod_events_latest_table ul li";
    String mainActivityErrorHtml = ".mod_events_latest_table p strong";

    String soupMealsIntroductionWebSite = "http://www.sks.itu.edu.tr/index.php?option=com_content&view=article&id=220";
    String soupMealsIntroductionCategoriesHtml = ".contentpaneopen tbody tr td ul li strong span";
    String soupMealsIntroductionDetailsHtml = ".contentpaneopen tbody tr td ul li span";

    String mainCourseMealsIntroductionWebSite = "http://www.sks.itu.edu.tr/index.php?option=com_content&view=article&id=226";
    String mainCourseMealsIntroductionCategoriesHtml = ".contentpaneopen tbody tr td ul li b";
    String mainCourseMealsIntroductionDetailsHtml = ".contentpaneopen tbody tr td ul li span";

    String sideCourseMealsIntroductionWebSite = "http://www.sks.itu.edu.tr/index.php?option=com_content&view=article&id=225";
    String sideCourseMealsIntroductionCategoriesHtml = ".contentpaneopen tbody tr td ul li b";
    String sideCourseMealsIntroductionDetailsHtml = ".contentpaneopen tbody tr td ul li span";

    String saladDessertIntroductionWebSite = "http://www.sks.itu.edu.tr/index.php?option=com_content&view=article&id=224";
    String saladDessertIntroductionCategoriesHtml = ".contentpaneopen tbody tr td ul li b";
    String saladDessertIntroductionDetailsHtml = ".contentpaneopen tbody tr td ul li span";
}
