name := "fluentlenium-play-scala-example"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  "com.typesafe.slick" %% "slick"         % "2.0.1",
  "postgresql"         %  "postgresql"    % "9.1-901.jdbc4",
  "org.seleniumhq.selenium" % "selenium-java" % "2.41.0" % "test",
  "org.fluentlenium" % "fluentlenium-core" % "0.10.0" % "test",
  "org.fluentlenium" % "fluentlenium-festassert" % "0.10.0" % "test"
)

play.Project.playScalaSettings
