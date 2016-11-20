#Software Design
![Eclipse-Color-Theme](http://p2.pdt-extensions.org/images/colorthemes/screenshot.png)
Team and contact:
* Carolina Moreira - up201303494@fe.up.pt
* Nuno Silva - up201404380@fe.up.pt
* Paulo Babo - up201404022@fe.up.pt
* Rita Carvalho - up201304918@fe.up.pt

##Introduction


This report aims to explain the Eclipse Color Theme architecture according to 4 + 1 view model of software architecture.
We begin to make an approach to Eclipse Color Theme architecture as well as to the model noted above. In the next points we approach a little more specific in respect to Logical view, Development view, Deployment view and Process view, with the help of illustrative diagrams.

##Eclipse Color Theme Architecture

##4+1 Architectural View Model

##Logical View

Below we can see the package diagram representing the logic view of the plugin.

![LogicView](eclipse-color-theme/ESOF-docs/Resources/LogicalView.jpg)

Eclipse Color Theme plugin is divided in three main packages.

**Themes package**: It has all the themes that comes bundled with the plugin.

**Mappings** package: It contains all the mappings for the multiple editors supported by this plugin.

**Eclipsecolortheme** package: This package is the core of the plugin, it applies the selected theme to eclipse. It has two more packages, mapper package and preferences package.
    
   * **Preferences** package handles the preference page of the plugin.

   * **Mapper** package handles the multiple mappings of the mappings package.




##Development View

##Deployment View

##Process View


##Contribuition of the team members




Introduction to Software Architecture and the 4+1 Architectural View Model; What are the architectural patterns followed by your project (if it doesn't follow any well known one, discuss whether it would be best to do so).
Grade: 4pts

Logical View
Grade: 4pts

Development View
Grade: 4pts

Deployment View
Grade: 4 pts

Process View
Grade: 4 pts
