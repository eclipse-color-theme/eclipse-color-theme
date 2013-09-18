Eclipse Color Theme
===================

Color themes for Eclipse.

Eclipse Color Theme makes it possible to import and switch color
themes conveniently and without side effects.

You can install the plugin from the
[update site](http://eclipse-color-theme.github.com/update).  After
installing, go to *Window->Preferences->General->Appearance->Color
Theme* to change the color theme.

**Please note:**

* When updating the plugin via Eclipse, go to the preferences page and
  press *OK* once, otherwise you won't see any changes. We're planning
  to fix this.
* When updating from an earlier version than 0.6, please uninstall the
  plugin and the update site, add the site listed above and install it
  again from there. Otherwise you won't see any updates.

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

* Text
* Java
* Java properties
* XML
* HTML
* CSS
* JavaScript
* C++
* PHP
* Ant
* SQL
* Python
* JSP
* Perl
* Groovy
* FDT
* ActionScript/MXML (Adobe Flash Builder)
* Ruby
* Scala
* FreeMarker (JBoss Tools)
* PDE
* ColdFusion (CFEclipse)
* TCL
* BibTex/LaTeX (TeXlipse)
* R (StatET)
* Erlang (ErlIDE)
* haXe (eclihx)
* Clojure (Counterclockwise)
* Go (GoClipse)
* Twig 
* Json (Json Eclipse Plugin)
* Yaml (Yedit)
* Xtend
* Markdown
* Spket IDE (JavaScript and XML)
* XSL
* DTD
* Haskell (EclipseFP)

Available themes:

* [Oblivion](http://www.eclipsecolorthemes.org/?view=theme&id=1)
* [Obsidian](http://www.eclipsecolorthemes.org/?view=theme&id=21)
* [Zenburn](http://www.eclipsecolorthemes.org/?view=theme&id=2)
* [RecognEyes](http://www.eclipsecolorthemes.org/?view=theme&id=30)
* [Inkpot](http://www.eclipsecolorthemes.org/?view=theme&id=4)
* [Vibrant Ink](http://www.eclipsecolorthemes.org/?view=theme&id=3)
* [Tango](http://www.eclipsecolorthemes.org/?view=theme&id=27)
* [Havenjark](http://www.eclipsecolorthemes.org/?view=theme&id=25)
* [frontenddev](http://www.eclipsecolorthemes.org/?view=theme&id=90)
* [NightLion Aptana Theme](http://www.eclipsecolorthemes.org/?view=theme&id=47)
* [Schuss](http://www.eclipsecolorthemes.org/?view=theme&id=29)
* [Notepadd++ Like](http://www.eclipsecolorthemes.org/?view=theme&id=91)
* [Sublime Text 2](http://www.eclipsecolorthemes.org/?view=theme&id=66)
* [Wombat](http://www.eclipsecolorthemes.org/?view=theme&id=118)
* [Pastel](http://www.eclipsecolorthemes.org/?view=theme&id=68)
* [minimal](http://www.eclipsecolorthemes.org/?view=theme&id=43)
* [Gedit Original Oblivion](http://www.eclipsecolorthemes.org/?view=theme&id=115)
* [Black Pastel](http://www.eclipsecolorthemes.org/?view=theme&id=128)
* [Mr](http://www.eclipsecolorthemes.org/?view=theme&id=32)
* [Monokai](http://www.eclipsecolorthemes.org/?view=theme&id=52)
* [Roboticket](http://www.eclipsecolorthemes.org/?view=theme&id=93)
* [Sunburst](http://www.eclipsecolorthemes.org/?view=theme&id=383)
* [Retta](http://www.eclipsecolorthemes.org/?view=theme&id=1004)

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

License
-------

Copyright (C) 2011 Felix H. Dahlke and Roger Dudler

This is open source software, licensed under the Eclipse Public
License. See the file COPYING for details.
