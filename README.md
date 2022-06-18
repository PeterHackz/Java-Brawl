# Java-Brawl
first open-source brawl stars private server written in java! (and first open-source v23 private server!)
## some stuff you should read
thank you [Icaro](https://github.com/IsaaSooBarr) for OwnHomeDataMessage structure

I did the code entirely from scratch by myself

if you don't know java or don't know how to run it, please don't contact me asking how.

if you want to learn from this project, feel free, just please don't ask me silly questions like 'how to run' (fun fact: I made it while learning Java)

this is made as a good server base in java, you can implement other packets and a database by yourself

have fun ^^

# setup the client 
this server don't use crypto, so we disable it. 

you have 2 options, either patch your own client or use my [patched client](https://www.mediafire.com/file/c79cm3v7cdyvevx/BrawlStars-v23.apk/file)

for the my patched client, you can change the server ip and port that the apk will connect to in `libjava-cat.config.so` in the libs folder

# how2run the server 
on android:

install Jvdroid, open pom.xml and run it.

on pc or others (basically anything that have java and maven installed in cmd):

- run in the same directory that have pom.xml
```
mvn package
```
- it will create a jar file, usually in target folder, use cd to reach it then run this command
```
java -jar JavaBrawl-1.0.jar
```

another option if you don't want to modify the source and don't have maven installed is using the [pre-compiled](https://github.com/SB-9838/Java-Brawl/tree/main/pre-compiled) jar file

# star
give a 🌟 for this repo because why not!

# issues
any NON-silly questions or issues?

contact me on discord:

S.B#0056

or join my [discord server](https://discord.gg/b2ejYcJjqA)

any opened issue in this repository will be deleted.
