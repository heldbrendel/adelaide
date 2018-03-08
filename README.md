Gitblit
=================

Gitblit is an open source, pure Java Git solution for managing, viewing, and serving [Git](http://git-scm.com) repositories.  It can serve repositories over the GIT, HTTP, and SSH transports; it can authenticate against multiple providers; and it allows you to get up-and-running with an attractive, capable Git server in less than 5 minutes.

More information about Gitblit can be found [here](http://gitblit.com).

<a href='https://bintray.com/gitblit/releases/gitblit/_latestVersion'><img src='https://api.bintray.com/packages/gitblit/releases/gitblit/images/download.png'></a>

License
-------

Gitblit is distributed under the terms of the [Apache Software Foundation license, version 2.0](http://www.apache.org/licenses/LICENSE-2.0).
The text of the license is included in the file LICENSE in the root of the project.

Java Runtime Requirement
------------------------------------

Gitblit requires at Java 7 Runtime Environment (JRE) or a Java 7 Development Kit (JDK).

Getting help
------------

| Source        | Location                                               |
| ------------- |--------------------------------------------------------|
| Documentation | [Gitblit website](http://gitblit.com)                  |
| Forums        | [Google Groups](https://groups.google.com/forum/#!forum/gitblit) |
| Twitter       | @gitblit or @jamesmoger                                |
| Google+       | +gitblit or +jamesmoger                                |

Contributing
------------

GitHub pull requests are preferred.  Any contributions must be distributed under the terms of the [Apache Software Foundation license, version 2.0](http://www.apache.org/licenses/LICENSE-2.0).

Building Gitblit
----------------

Gitblit uses submodules.
Make sure to clone using `--recursive` OR to execute `git submodule update --init --recursive`.

- Using JUnit, execute the `com.gitblit.tests.GitBlitSuite` test suite.
*This will clone some repositories from the web and run through the unit tests.*
- Execute the *com.gitblit.GitBlitServer* class to start Gitblit GO.

Building Tips & Tricks
----------------------
