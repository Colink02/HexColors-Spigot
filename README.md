# HexColors-Spigot

Simple API to implement &#FFFFFF hex codes for a colorful chatting

Required Maven Dependencies
1.18.2 (Spigot API 1.18.2 Already has bungeecord-chat as a dependency)
```xml
<repositories>
  <repository>
    <id>spigot-repo</id>
    <url>https://hub.spigotmc.org/nexus/content/repositories/snapshots/</url>
  </repository>
 </repositories>
 <dependencies>
   <dependency>
    <groupId>org.spigotmc</groupId>
    <artifactId>spigot-api</artifactId>
    <version>1.18.2-R0.1-SNAPSHOT</version>
    <scope>provided</scope>
  </dependency>
 </dependencies>
```
Gradle
```gradle
repositories {
  maven {
        url = 'https://hub.spigotmc.org/nexus/content/repositories/snapshots/'
        content {
            includeGroup 'org.bukkit'
            includeGroup 'org.spigotmc'
        }
    }
}
dependencies {
  compileOnly 'org.spigotmc:spigot-api:1.18.2-R0.1-SNAPSHOT'
}
```
