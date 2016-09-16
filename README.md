Eclipse Color Theme
===================

Color themes for Eclipse.

Eclipse Color Theme makes it possible to import and switch color
themes conveniently and without side effects.

You can install the plugin from the
[update site](http://eclipse-color-theme.github.com/update) (there's
also an archive of the site for offline installation). After
installing, go to *Window->Preferences->General->Appearance->Color
Theme* to change the color theme.

**Please note:**

* When updating the plugin via Eclipse, go to the preferences page and
  press *OK* once, otherwise you won't see any changes. We're planning
  to fix this.
* When updating from an earlier version than 0.6, please uninstall the
  plugin and the update site, add the site listed above and install it
  again from there. Otherwise you won't see any updates.

[![Build Status](https://secure.travis-ci.org/eclipse-color-theme/eclipse-color-theme.png)](http://travis-ci.org/eclipse-color-theme/eclipse-color-theme)

Rationale
---------

While Eclipse allows you to change the syntax coloring in great
detail, there is no support for managing multiple color themes. It is
possible to achieve that by importing and exporting preferences files,
but this is inconvenient and likely to mess up your preferences.
Furthermore, color themes have to be created for every single editor,
a theme for the Java editor does not change the XML, JavaScript or
any other editors. This plugin solves these issues by mapping a
generic color theme format to specific preferences entries for each
supported editor.

Editors and themes
------------------

Eclipse Color Theme currently supports the following editors:

* ActionScript/MXML (Adobe Flash Builder)
* Ant
* BibTex/LaTeX (TeXlipse)
* C++
* Clojure (Counterclockwise)
* ColdFusion (CFEclipse)
* [Chromium Debugger JavaScript Editor](https://github.com/Nodeclipse/nodeclipse-1/tree/master/chromedevtools/plugins/org.chromium.debug.ui)
* CSS
* DTD
* Erlang (ErlIDE)
* FDT
* FreeMarker (JBoss Tools)
* Go (GoClipse)
* Gradle ([Nodeclipse/Enide Minimalist Gradle Editor](http://www.nodeclipse.org/projects/gradle))
* Groovy
* Haskell (EclipseFP)
* haXe (eclihx)
* HTML (Eclipse WTP, [AngularJS Eclipse Plugin](https://github.com/angelozerr/angularjs-eclipse))
* IvyDE editor ([Apache IvyDE](http://ant.apache.org/ivy/ivyde/))
* Jade (Node.js template engine; [Nodeclipse/Enide Minimalist Jade Editor](http://www.nodeclipse.org/projects/gradle))
* Java
* Java properties (Eclipse JDT, [Properties Editor](http://propedit.sourceforge.jp/index_en.html))
* JavaScript
* Json ([Json Eclipse Plugin](https://github.com/pulse00/Json-Eclipse-Plugin), [Eclipse Json Editor Plugin](http://sourceforge.net/projects/eclipsejsonedit/), [JsonTools](https://bitbucket.org/denmiroch/jsontools/wiki/Home))
* JSP
* Less ([Eclipse plugin for LESS](http://www.normalesup.org/~simonet/soft/ow/eclipse-less.fr.html))
* Markdown
* PDE
* Perl
* [Protocol Buffers](https://code.google.com/p/protobuf-dt)
* PHP
* Puppet (Gepetto)
* Python
* R (StatET)
* Ruby
* Scala
* Spket IDE (JavaScript and XML)
* SQL
* TCL
* Text
* Twig
* TypeScript ([Eclipse TypeScript Plug-in](https://github.com/palantir/eclipse-typescript), [TypeScript IDE for Eclipse](http://typecsdev.com/))
* XML
* XSL
* Xtend
* Yaml (Yedit)

Available themes:

* [Black Pastel](http://www.eclipsecolorthemes.org/?view=theme&id=128)
* [frontenddev](http://www.eclipsecolorthemes.org/?view=theme&id=90)
* [Gedit Original Oblivion](http://www.eclipsecolorthemes.org/?view=theme&id=115)
* [Havenjark](http://www.eclipsecolorthemes.org/?view=theme&id=25)
* [Inkpot](http://www.eclipsecolorthemes.org/?view=theme&id=4)
* [minimal](http://www.eclipsecolorthemes.org/?view=theme&id=43)
* [Monokai](http://www.eclipsecolorthemes.org/?view=theme&id=52)
* [Mr](http://www.eclipsecolorthemes.org/?view=theme&id=32)
* [NightLion Aptana Theme](http://www.eclipsecolorthemes.org/?view=theme&id=47)
* [Notepadd++ Like](http://www.eclipsecolorthemes.org/?view=theme&id=91)
* [Oblivion](http://www.eclipsecolorthemes.org/?view=theme&id=1)
* [Obsidian](http://www.eclipsecolorthemes.org/?view=theme&id=21)
* [Pastel](http://www.eclipsecolorthemes.org/?view=theme&id=68)
* [RecognEyes](http://www.eclipsecolorthemes.org/?view=theme&id=30)
* [Retta](http://www.eclipsecolorthemes.org/?view=theme&id=1004)
* [Roboticket](http://www.eclipsecolorthemes.org/?view=theme&id=93)
* [Schuss](http://www.eclipsecolorthemes.org/?view=theme&id=29)
* [Solarized Dark](http://www.eclipsecolorthemes.org/?view=theme&id=1115)
* [Solarized Light](http://www.eclipsecolorthemes.org/?view=theme&id=1013)
* [Sublime Text 2](http://www.eclipsecolorthemes.org/?view=theme&id=66)
* [Sunburst](http://www.eclipsecolorthemes.org/?view=theme&id=383)
* [Tango](http://www.eclipsecolorthemes.org/?view=theme&id=27)
* [Vibrant Ink](http://www.eclipsecolorthemes.org/?view=theme&id=3)
* [Wombat](http://www.eclipsecolorthemes.org/?view=theme&id=118)
* [Zenburn](http://www.eclipsecolorthemes.org/?view=theme&id=2)

You can download additional themes or create your own on
[eclipsecolorthemes.org](http://eclipsecolorthemes.org).

Contributing
------------

Since pretty much all Eclipse Color Theme users are developers, and
since it supports many more editors than a single person could
possibly want to use, the project has always been driven by
[our fantastic contributors](https://github.com/eclipse-color-theme/eclipse-color-theme/graphs/contributors).

Please consider contributing if you're missing support for an editor,
get annoyed by a bug or just want to help - it's greatly appreciated!
See the [contributor guide](https://github.com/eclipse-color-theme/eclipse-color-theme/wiki/Contributing)
for a start.

Building
--------

You can generate an update site using [Maven](http://maven.apache.org/):

    mvn clean verify

This will create an update site in
_com.github.eclipsecolortheme.updatesite/target/repository_.

By default, Eclipse Color Theme will be built against the Eclipse Mars
version of the platform. You can build against either Eclipse Luna or
Kepler by setting the "platform-version" property, for example:

    mvn clean verify -Dplatform-version=kepler

License
-------

Copyright (C) 2010-2014 Felix H. Dahlke and Roger Dudler

This is open source software, licensed under the Eclipse Public
License. See the file COPYING for details.
