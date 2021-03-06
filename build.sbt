lazy val akkaHttpVersion = "10.2.1"
lazy val akkaVersion    = "2.6.10"

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization    := "example",
      scalaVersion    := "2.13.3"
    )),
    name := "scala-example",
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-http"                % akkaHttpVersion,
      "com.typesafe.akka" %% "akka-http-spray-json"     % akkaHttpVersion,
      "com.typesafe.akka" %% "akka-actor-typed"         % akkaVersion,
      "com.typesafe.akka" %% "akka-stream"              % akkaVersion,
      "com.typesafe.akka" %% "akka-persistence-typed"   % akkaVersion,
      "ch.qos.logback"    % "logback-classic"           % "1.2.3",
      "net.petitviolet"   %% "ulid4s"                   % "0.5.0",

      "joda-time"         % "joda-time"                 % "2.10.9",
      "org.joda"          % "joda-convert"              % "2.2.1",

      "com.typesafe.akka" %% "akka-http-testkit"        % akkaHttpVersion % Test,
      "com.typesafe.akka" %% "akka-actor-testkit-typed" % akkaVersion     % Test,
      "com.typesafe.akka" %% "akka-persistence-testkit" % akkaVersion     % Test,
      "org.scalatest"     %% "scalatest"                % "3.0.8"         % Test
    )
  )
