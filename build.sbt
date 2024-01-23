name := "scalaj-http"

version := "2.5.0"

organization := "com.codacy"

scalaVersion := "2.12.15"

libraryDependencies ++= Seq(
  "junit"                         % "junit"                 % "4.13.2"             % "test",
  "com.github.sbt"                % "junit-interface"       % "0.13.3"             % "test",
  "org.eclipse.jetty"             % "jetty-server"          % "8.2.0.v20160908"    % "test",
  "org.eclipse.jetty"             % "jetty-servlet"         % "8.2.0.v20160908"    % "test",
  "org.eclipse.jetty"             % "jetty-servlets"        % "8.2.0.v20160908"    % "test",
  "com.fasterxml.jackson.module"  %% "jackson-module-scala" % "2.13.2"             % "test"
)

enablePlugins(BuildInfoPlugin)
buildInfoKeys := Seq[BuildInfoKey](version)
buildInfoPackage := "scalaj.http"

crossScalaVersions := Seq("2.12.15", "2.13.7", "3.1.0")

javacOptions ++= Seq("-source", "1.8", "-target", "1.8")

scalacOptions ++= Seq(
  "-deprecation",
  "-unchecked",
  "-Xfuture"
)

scalacOptions in (Compile, doc) ++= Seq("-doc-root-content", baseDirectory.value+"/root-doc.txt")

licenses := Seq("The Apache Software License, Version 2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0.txt"))

homepage := Some(url("https://github.com/codacy/scalaj-http"))

scmInfo := Some(
  ScmInfo(url("https://github.com/codacy/scalaj-http"), "scm:git:git@github.com:codacy/scalaj-http.git")
)

// this setting is not picked up properly from the plugin
pgpPassphrase := Option(System.getenv("SONATYPE_GPG_PASSPHRASE")).map(_.toCharArray)

publicMvnPublish
