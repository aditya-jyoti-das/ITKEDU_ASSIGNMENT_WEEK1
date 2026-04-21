Task: Development of a library for working with geometric shapes.

Create the GeometryLibrary project
Create a new project named GeometryLibrary, in which you define classes representing geometric shapes such as a circle, rectangle, and triangle. Each shape must have methods for calculating area and perimeter.

Create the GeometryApp project
In the GeometryApp project, create an application that uses the GeometryLibrary. Create objects of different geometric shapes and output information about their area and perimeter.

Additional task: Version management
Set the version of the GeometryLibrary project to 1.0.0. Make small changes to the library code and update the version to 1.1.0. In the GeometryApp project, update the dependency to the new version of the library.

Dependency and conflict management
Create a module named GeometryUtils in the GeometryLibrary project, which defines additional functions for manipulating geometric data (for example, unit conversion, shape comparison, etc.).

Set the version of GeometryUtils to 1.0.0-SNAPSHOT.

In the GeometryApp project, add a dependency on GeometryUtils and use its functionality.

Modify the GeometryUtils module and increase its version to 1.1.0-SNAPSHOT.

In the GeometryApp project, attempt to update the GeometryUtils dependency to the new version and resolve any dependency conflicts.

In the GeometryLibrary project, add support for three-dimensional shapes (cube, sphere, etc.) by creating a new module ThreeDimensionalShapes.

Set the version of ThreeDimensionalShapes to 1.0.0-SNAPSHOT.

Update the GeometryApp project so that it can work with both two-dimensional and three-dimensional shapes.

When updating the ThreeDimensionalShapes version to 1.1.0-SNAPSHOT, resolve any possible dependency conflicts.