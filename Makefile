antlr4 = java org.antlr.v4.Tool
grun = java org.antlr.v4.gui.TestRig
SRCFILES = main.java AST.java Environment.java
GENERATED = implParser.java implBaseVisitor.java implVisitor.java implLexer.java

all:
	make hw3

main.class:	$(SRCFILES) $(GENERATED) impl.g4
	javac  $(SRCFILES) $(GENERATED)

implLexer.java:	impl.g4
	$(antlr4) -visitor impl.g4


implLexer.class: implLexer.java
	javac $(GENERATED)

hw1:	implLexer.class main.class impl.g4 01-hello-world.hw
	java main 01-hello-world.hw

hw2: 	implLexer.class main.class impl.g4 02-trafiklys-minimal.hw
	java main 02-trafiklys-minimal.hw
	
hw3:	implLexer.class main.class impl.g4 03-trafiklys.hw
	java main 03-trafiklys.hw
	
hw4: 	implLexer.class main.class impl.g4 04-group6.hw
	java main 04-group6.hw

tree1:	implLexer.class impl.g4 01-hello-world.hw
	$(grun) impl start -gui -tokens 01-hello-world.hw

tree2:	implLexer.class impl.g4 02-trafiklys-minimal.hw
	$(grun) impl start -gui -tokens 02-trafiklys-minimal.hw

tree3:	implLexer.class impl.g4 03-trafiklys.hw
	$(grun) impl start -gui -tokens 03-trafiklys.hw

tree4:	implLexer.class impl.g4 04-group6.hw
	$(grun) impl start -gui -tokens 04-group6.hw
