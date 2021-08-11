# Particable
A Particle API

## Usage
Create a particle using `Particle.particle(...)`
```kt
val particle = Particle.particle(
  type = ParticleType.VILLAGER_HAPPY,
  count = 5,
  data = OffsetAndSpeed(0.5f, 1f, 0.5f, 0.2f)
)
```
The type of `data` is determined by the Particle type. It's either `OffsetAndSpeed` (for most types) or `Color` (for effect particles).
```kt
val particle = Particle.particle(
  type = ParticleType.ENTITY_EFFECT,
  count = 10,
  data = Color(1f, 0f, 0f, 1f)
)
```
Some particles require extra data, provided by the `extraData` parameter.
```kt
val particle = Particle.particle(
  type = ParticleType.DUST,
  count = 1,
  data = OffsetAndSpeed(0f, 0f, 0f, 0f),
  extraData = Dust(0f, 1f, 0f, scale = 1f)
)
```
`type` and `count` also accept suppliers, that are called every time the particle is used.
***
To show the particle, call `Audience.showParticle(Particle, Particle.Renderer)`.

The renderers are methods on the companion of `Renderer`. `Position` is also accepted.
```kt
// Show the particle on a single position
audience.showParticle(particle, position)
// Or
audience.showParticle(particle, Renderer.point(position))

// Render a circle
audience.showParticle(particle, Renderer.circle(position, 5))
```
For all renderers visit [Renderer.kt](https://github.com/Project-Cepi/Particable/blob/main/Minestom/src/main/kotlin/world/cepi/particle/Renderer.kt)
