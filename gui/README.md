# GUI Demo

## Table of Contents

* [Terminal Commands](#terminal-commands)
* [Basic deployment](#basic-deployment)
* [Modules](#modules)
* [Notification](#notification)
* [Browser Support](#browser-support)

## Terminal Commands

This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 8.0.2 and angular 8.x.

1. Install NodeJs from [NodeJs Official Page](https://nodejs.org/en).

2. Open Terminal

3. Go to your project root

   ```
   cd guidemo/gui
   ```

4. Download npm packages to `node_modules`

   ```
   npm install
   ```

   **In real production repository, we will provide integrated `node_modules` which contains all required npm pakcages. In this way, the build can be made locally.**

5. Make sure you have installed [Angular CLI](https://github.com/angular/angular-cli) already. If not, please install.

   ```
   npm install -g @angular/cli
   ```

6. Run ng serve for a dev server. Navigate to http://localhost:4200/. The app will automatically reload if you change any of the source files.

   ```
   ng serve --open
   ```

   To get more help on the Angular CLI use `ng help` or go check out the [Angular CLI README](https://github.com/angular/angular-cli/blob/master/README.md) or read the Angular's [user manual](https://angular.io/cli).

7. Run restful service application

   ```
   # go to spring boot project root
   cd guidemo/demo
   
   # build latest
   mvn clean install
   
   # start web server
   java -jar target/demo-0.0.1-SNAPSHOT.jar
   ```

## Basic deployment

For the simplest deployment, create a production build and copy the output directory to a web server.

1. Start with the production build

   ```
   ng build --prod
   ```

2. Copy *everything* within the output folder (`dist/` by default) to a folder on the server.

3. Configure the server to redirect requests for missing files to `index.html`. 

## Modules

### Modules with dynamic data so far

- device

### Modules with static data so far

- policy
- dashboard

## Notification

In real production repository, we will provide integrated `node_modules` which contains all required npm pakcages. In this way, the build can be made locally.

## Browser Support

At present, we officially aim to support the last two versions of the following browsers:

<img src="https://s3.amazonaws.com/creativetim_bucket/github/browser/chrome.png" width="64" height="64"> <img src="https://s3.amazonaws.com/creativetim_bucket/github/browser/firefox.png" width="64" height="64"> <img src="https://s3.amazonaws.com/creativetim_bucket/github/browser/edge.png" width="64" height="64"> <img src="https://s3.amazonaws.com/creativetim_bucket/github/browser/safari.png" width="64" height="64"> <img src="https://s3.amazonaws.com/creativetim_bucket/github/browser/opera.png" width="64" height="64">

 