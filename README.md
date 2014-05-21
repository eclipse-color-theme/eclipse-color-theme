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
* CSS
* DTD
* Erlang (ErlIDE)
* FDT
* FreeMarker (JBoss Tools)
* Go (GoClipse)
* Groovy
* Haskell (EclipseFP)
* haXe (eclihx)
* HTML (Eclipse WTP, [AngularJS Eclipse Plugin](https://github.com/angelozerr/angularjs-eclipse))
* Java
* Java properties (Eclipse JDT, [Properties Editor](http://propedit.sourceforge.jp/index_en.html))
* JavaScript
* Json ([Json Eclipse Plugin](https://github.com/pulse00/Json-Eclipse-Plugin), [Eclipse Json Editor Plugin](http://sourceforge.net/projects/eclipsejsonedit/), [JsonTools](https://bitbucket.org/denmiroch/jsontools/wiki/Home))
* JSP
* Markdown
* PDE
* Perl
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
* TypeScript
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

Adding a theme
--------------

To create a new theme, go to
[eclipsecolorthemes.org](http://eclipsecolorthemes.org), create it,
download it in *.xml format and import it from the Color Theme
preference page.

Adding a mapping
----------------

If you would like to add an editor mapping, proceed as follows:

1. Go to the *syntax coloring* preferences page of the editor,
e.g. *C/C++->Editor->Syntax Coloring*.

2. Look at the colour theme keys of one theme (See `ColorThemeKeys`
for all available keys) and set up the syntax colouring using the
colours defined there.

3. Open the editor's preferences file,
e.g. *workspace/.metadata/.plugins/org.eclipse.core.runtime/.settings/org.eclipse.cdt.ui.prefs*
and create a new XML file named after the plugin ID in the *mapper*
directory which maps the colour theme's keys to those of the editor.

4. Open *plugin.xml* and add the new mapping file to the extension point *com.github.eclipsecolortheme.theme*.

Building
--------

### Generating an update site

If you just want to generate an update site from the sources, you can
do so using [Maven](http://maven.apache.org/):

    mvn clean verify

This will create an update site in
_com.github.eclipsecolortheme.updatesite/target/repository_.

### Development

All you need is [Eclipse PDE](http://www.eclipse.org/pde/). Once you
have that, you can import the projects in this repository into an
Eclipse workspace.

License
-------

Copyright (C) 2011 Felix H. Dahlke and Roger Dudler

This is open source software, licensed under the Eclipse Public
License. See the file COPYING for details.
