
#Requirements
![Eclipse-Color-Theme](http://p2.pdt-extensions.org/images/colorthemes/screenshot.png)
Team and contact:
* Carolina Moreira - up201303494@fe.up.pt
* Nuno Silva - up201404380@fe.up.pt
* Paulo Babo - up201404022@fe.up.pt
* Rita Carvalho - up201304918@fe.up.pt

##Introduction

The main purpose of this document is to give a detailed description about Eclipse Color Theme. We intend to illustrate the purpose, the features and the goals of the project, and what we can do with it. This document is directed to both the developers and users of Eclipse Color Theme.

##Purpose

Eclipse Color Theme was developed with the purpose of making it possible to import and switch color themes conveniently and without side effects.

##Requirements Elicitation

Since most, if not all, Eclipse Color Theme users are developers, the development process can be called "Nothing Formal". The main requirements of the project are: create new mappings to add support for an editor, create new themes, fixing bugs and if you would like to add new features, you could just open an issue and wait for a response.
The ideal setup to build new mapping would be to perform the following steps:

1. Go to the syntax coloring preferences page of the editor, e.g. C/C++->Editor->Syntax Coloring;
2. Look at the colour theme keys of any theme (See the ColorThemeKeys class for all available keys) and configure the syntax colouring manually using the colours defined there;
3. Open the editor's preferences file, e.g. workspace/.metadata/.plugins/org.eclipse.core.runtime/.settings/org.eclipse.cdt.ui.prefs and create a new XML file named after the plugin ID in the mapper directory which maps the colour theme's keys to those of the editor;
4. Open plugin.xml and add the new mapping file to the extension point com.github.eclipsecolortheme.theme;
5. Create a pull request.

And the ideal setup to build new themes would be to perform the following steps:

1. Go to eclipsecolorthemes.org;
2. Log-in or create a new account;
3. create the new theme by editing the values;
4. Download it in *.xml format and import it from the Color Theme preference page;
5. Check if the new theme would be popular and if it is new;
6. Create a pull request.

There is a new stable version launched every few months, in which the new features created since the previous version are implemented, completely ready, having been validated and tested.

##Requirements

Some project requirements at the funtional level are:

1. Change the color of the menus;
2. Change the size of the font;
3. Change the color of the font;
4. Change the syntax coloring in great detail;

##Use Cases

![UseCases](http://i.imgur.com/7UFnv5M.png)

##Validation

//TODO

##Versioning usage

As mentioned before, the project leader tries to get out a release every few months. The main reason for that happen is that the project leader want to do some testing before releasing a new version, and he don't have time to do it in shorter cycles.
The name of which version follow the pattern "Incrementing sequences" that is a method that treat versions as a series of individual numbers, separated by periods, with a progression.


##Domain

//TODO

##Contribuition of the team members

//We felt that in this second report, the distribution of work was pretty even, leaving everyone with about 25% of the work done.


The goal of this second assignment is to investigate how the project deals with requirement elicitation in the project that you're studying. As in the first assignment,  as this is a topic that may not be explicitly reported in the repository, it may require you to contact the team members to find out more. If that is the case, you should cite/credit the person you talked to.

In particular, this first report should discuss the following

Requirements: Introduction, Purpose/Scope, and Description
Grade: 3pts
Note: This is a generic introduction to requirements as well as requirements elicitation in the project (how is this done? How does the team decides on whether to implement a new features, etc. )
Specific Requirements and Features (Functional and Non-Functional requirements)
Grade: 5pts
Use Cases (including diagrams)
Grade: 6pts
Domain Model
Grade: 6 pts
Submission date (i.e., last commit to the repository): 23:59, 30-10-2016.

Note: Include contribution of the team members in the report. It also has to be clear from the commits to the repository the contributions of the different team members. 
