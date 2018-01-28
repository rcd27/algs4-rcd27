#### About
This is just my progress of learning algorithms from *Princeton Course*
by *Robert Sedgewik* and *Kevin Wayne*.

#### Links
<a href="https://www.coursera.org/learn/algorithms-part1">Algorithms,
Part I</a>

#### Help
To install `algs4.jar` for Maven project:
- Download <a href="">jar-file</a>
- Install it in `.m2` (local Maven repository) so you will be able to use it in different projects:
    ```
    mvn install:install-file
       -Dfile=<path-to-file>
       -DgroupId=edu.princeton.cs
       -DartifactId=algs4
       -Dversion=1.0
       -Dpackaging=jar
       -DgeneratePom=true
    ```

    Where: <path-to-file>  the path to the file to load
       <group-id>      the group that the file should be registered under
       <artifact-id>   the artifact name for the file
       <version>       the version of the file
       <packaging>     the packaging of the file e.g. jar
- Add a dependency to the `pom.xml`:
    ``` xml
    <dependency>
        <groupId>edu.princeton.cs</groupId>
        <artifactId>algs4</artifactId>
        <version>1.0</version>
    </dependency>
    ```
- Or just add it directly to the `pom.xml`:
    ``` xml
    <dependency>
        <groupId>edu.princeton.cs</groupId>
        <artifactId>algs4</artifactId>
        <version>1.0</version>
        <scope>system</scope>
        <systemPath>${project.basedir}/path/to/jar/algs4.jar</systemPath>
    </dependency>
    ```
