
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

###Functional level requirements

Funtional level requirements specifie the things the programm should do or accomplish, that is, they should represent a funtion  or a particular result of the system.
Some project requirements at the funtional level are:

1. Change the color of the menus;
2. Change the size of the font;
3. Change the color of the font;
4. Change the syntax coloring in great detail;

###Non-functional level requirements

Non-functional level requirements contrasts with the funtional level ones because they must specifie overall property of the system as a whole or of a particular aspect, they can even show some criteria that can help judge that same system in the operation level rather than in a specific behavior one.
Some project requirements at the non-functional level are:

1. Open Source Project
2. Free software and support
3. Continuous extensibility
4. A high compatibility with the editors
5. Really user friendly
6. Reusable

##Use Cases

Sometimes it is important to understand the type of use that a particular application will have to determine which requirements may apply. In this context, the diagram below shows the main use cases of Eclipse Color Theme.


![UseCases](https://github.com/Miridinia/eclipse-color-theme/blob/master/ESOF-docs/Resources/Use%20Cases.jpg)


##Validation

Since there are no deadlines for the design, development can be done in a careful way, always requiring some kind of validation for the developers contributions are positive fact for the project.
In the Eclipse Color Theme project there aren't any  evident barrier for validation of the requirements once the contributors are free to develop new features, asking for aprove only in the moment of merge the new feature and the initial project (pull request). The pull request is reviewed normally by the user Felix H. Dahlke (fhd) and either approved, in which case the code is merged into the main repository, or denied when the code has errors or isn't popular enought. The code is tested locally to make sure it works and does what is advertised. 


##Versioning usage

As mentioned before, the project leader tries to get out a new release every few months. The main reason why that happens is that the project leader wants to do some testing before releasing the new version, but he doesn't have the time to do it in shorter cycles.
The version naming follows the pattern of "Incrementing sequences", that is, a method that treat versions as a series of individual numbers, separated by periods, progressively.


##Domain

![Domain](https://github.com/Miridinia/eclipse-color-theme/blob/master/ESOF-docs/Resources/Domain.jpg)


##Contribuition of the team members

Although the work was more distributed than in the previous report, we feel that the variation between different people and their work  doesn't warrant an unalike division of the contribution, therefore, we also apply 25% to each individual member of the team.
