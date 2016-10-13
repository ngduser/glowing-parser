#Glowing Parser

##What is it?

Glowing Parser is an LL(1), top down, right-associative recursive descent parser for a context-free GUI definition language to create Java Swing applications. The Glowing Parser is very object oriented in structure as every non-terminal from the language is created as class objects comprised of unique tokens without duplication, are self validating, and each one constructs a Gui object from only what it contains through instantiation.

##Process

Glowing Parser uses a set of static functions on a user specified input file which it processes through a lexical analysis filter to identify key tokens that it builds into a parse tree data structure outline. Non-terminals are identified through enumeration where they are instantiated as objects. The stream following the instantiation is added to the open non-terminal until either it is closed or another non-terminal is opened within the parent, in which case the stream following the declaration would be added as content to the child non-terminal. 

Once the tree has been completed and populated, the resulting data structure goes through a building process where each child object formats itself with the parent in a way which creates a valid java translation that continues up in to the root. This process destroys the nodes as it builds up and is inherently destructive to the child objects. 

##Contributions

This project was designed for a school assignment so at the time there is little forward development planned, but feel free to fork it off or add contributions nonetheless. It is robust enough to allow for more development along with the definition language or can be adapted to more prevailing langauges to translate into Java using Swing. 

##Licensing

I am releasing this project under the MIT license as described here- https://opensource.org/licenses/MIT so feel free to do pretty much whatever.

