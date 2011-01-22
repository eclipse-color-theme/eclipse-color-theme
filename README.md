Eclipse Color Theme
===================

Color themes for Eclipse.

Eclipse Color Theme makes it possible to switch color themes
conveniently and without side effects. Support for importing and
exporting of themes is planned.

You can install the plugin from the
[update site](http://fhd.github.com/eclipse-color-theme).  After
installing, go to *Window->Preferences->General->Appearance->Color
Theme* to change the color theme.

When updating the plugin via Eclipse, go to the preferences page and
press *OK* once, otherwise you won't see any changes. I'm planning to
fix this.

[![Flattr this](http://api.flattr.com/button/flattr-badge-large.png "Flattr this")](http://flattr.com/thing/111560/Eclipse-Color-Theme)

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

Available themes:

* [Inkpot](http://www.vim.org/scripts/script.php?script_id=1143)
* [Zenburn](http://slinky.imukuppi.org/zenburnpage/)
* [Vibrant Ink](http://code.google.com/p/vibrant-ink-textmate/)
* [Oblivion](http://www.rogerdudler.com/?p=362)

All converted from [these preferences files](https://eclipsecolorthemes.jottit.com/).

Adding a theme
--------------

To create a new theme, you'll have to get the source and build the
plugin until theme importing/exporting is implemented.

Create an XML file in the *com.github.fhd.eclipsecolortheme.themes*
package next to *zenburn.xml* and change the colour values until
you're satisfied. Then add the file name to the constant `FILE_NAMES`
in `ColorThemeManager`.

The keys are quite Java-specific right now, but the entries are mapped
to other editors (e.g. the *method* key is used for XML/HTML
tags). None of the current file uses all keys, so you'll have to look
at each to see what's possible.

Adding an editor
----------------

If you would like to add an editor, proceed as follows:

1. Go to the *syntax coloring* preferences page of the editor,
e.g. *C/C++->Editor->Syntax Coloring*.

2. Look at the colour theme keys of one theme (I suggest you use
Zenburn for that) in this plugin's `ColorThemeManager` class and set
up the syntax colouring using the colours defined there.

3. Open the editor's preferences file, e.g. *workspace/.metadata/.plugins/org.eclipse.core.runtime/.settings/org.eclipse.cdt.ui.prefs*
and create a new subclass of `ThemePreferenceMapper` where you map the
colour theme's keys to those of the editor.

License
-------

Copyright (C) 2011 Felix H. Dahlke

This is open source software, licensed under the Eclipse Public
License. See the file COPYING for details.
