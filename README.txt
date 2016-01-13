Multi-threaded Cypher Breaker
=============================
TextScorer:
Uses ConcurrentHashMap to store and compare the text wether is english or not

Resultable:
Creates plain text for cypher , and calls methods

Result:
implements resultable class & assigns variables in resultable class

RailFence:
Basic implementation of the rail fence cipher using 2d char array encrypt / decrypt 

QuadGramMap:
Sets quadgram size to equal to 4

PoisonResult:
Extents result and implements resultable 

FileParser:
Reads file 4grams.txt stores it in a ConcurrentHashMap

Decryptor:
Implements runnable and decrypts text , blocking que 

CypherBreaker:
Creates thread prints

=====================================================================================================
Runner class runs the whole program + menu , I have provided Test.txt & Test2.txt for testing purposes!
 


