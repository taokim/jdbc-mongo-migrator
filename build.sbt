organization := "jm.migrator"

name := "jdbc-mongo-migrator"

scalaVersion := "2.8.1"

resolvers <<= (resolvers) { r =>
    (Option(System.getenv("SBT_PROXY_REPO")) map { url =>
        Seq("proxy-repo" at url)
    } getOrElse {
        r ++ Seq(
            "scala-tools" at "http://scala-tools.org/repo-releases/",
            "maven" at "http://repo1.maven.org/maven2/",
            "freemarker" at "http://freemarker.sourceforge.net/maven2/",
            "sbt-idea-repo" at "http://mpeltonen.github.com/maven/"
        )
    }) ++ Seq("local" at ("file:" + System.getProperty("user.home") + "/.m2/repository/"))
}

libraryDependencies ++= Seq(
    "net.liftweb" %% "lift-json" % "2.2",
    "com.mongodb.casbah" %% "casbah" % "2.0.2",
    "mysql" % "mysql-connector-java" % "5.1.12",
    "com.h2database" % "h2" % "1.3.152",
    "net.lag" % "configgy" % "2.0.0" intransitive(),
    "org.scalatest" % "scalatest" % "1.3"
)

mainClass in (Compile, run) := Some("jm.migrator.Launcher")