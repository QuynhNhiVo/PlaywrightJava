# Playwright with Java - Web Automation Framework

This project demonstrates the usage of Playwright with Java for web automation, using the provided test cases and various Playwright concepts. The automation scripts focus on testing the HR Sale application available at https://app.hrsale.com/erp/login.

This framework was created as part of learning from the Playwright With Java Series - Web Automation With Framework by Mukesh Otwani on YouTube.

## Playlist Overview

The series covers how to use Playwright, a powerful browser automation tool, with Java to automate web applications. The following test cases were created based on the lessons from the series, focusing on core automation techniques with Playwright.

## Topics Covered

The following test cases have been implemented as part of this project:

### 1. Locator:

Covers different types of locators in Playwright (CSS selectors, XPath, text selectors) to interact with web elements.
### 2. Dropdown:

Automates the selection and verification of values in dropdown menus using Playwright.
### 3. Frame_IFrame:

Automates the interaction with elements inside iframes or frames, useful for web applications with embedded content.
### 4. Alert:

Automates the process of handling JavaScript alerts (e.g., accepting or dismissing alert boxes).

Demonstrates automation of checkboxes and radio buttons (selecting, unselecting, and verifying states).
### 2. MultiplePages_Tabs:

Automates scenarios involving multiple browser tabs or windows, useful when testing web applications that open new tabs or windows.
### 2. Screenshot_Record:

Captures screenshots and records video during test execution, which helps in visual verification and debugging.
### 2. Upload_And_DownLoad_File:

Automates file upload and download functionality on the website, verifying the correct handling of file input elements.

## Test Website

The primary website being tested is HR Sale - ERP Login. All scripts are designed to interact with this login page and perform various user actions.

## Prerequisites

Java 21
Maven 
IntelliJ IDEA

## Install Dependencies

* Playwright (com.microsoft.playwright:playwright:1.49.0)
* TestNG (org.testng:testng:7.10.2)
* Log4j Core (org.apache.logging.log4j:log4j-core:2.24.2)
* Log4j API (org.apache.logging.log4j:log4j-api:2.24.2)
* SLF4J API (org.slf4j:slf4j-api:2.0.16)
* SLF4J Simple (org.slf4j:slf4j-simple:2.0.16)
