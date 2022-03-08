# Particable
A list-based particle API.

## Usage

### Single Particle

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
### Renderers

Renderers are a list of points, represented by either Java's Iterable or Kotlin's Sequence.

To show a particle, call `Audience.showParticle(Particle, Particle.Renderer)`.

Renderers can be made simply by passing a list, iterable, or sequence of vectors, as well as in the Renderer companion methods
```kt
// Show the particle on a single vector
audience.showParticle(particle, vector)
// Or
audience.showParticle(particle, Renderer.point(vector))

// Render a circle
audience.showParticle(particle, Renderer.circle(vector, 5))
```

Since renderers are vecs or iterables, you can transform Renderers however you want.

The optimal case is to design your shapes around `0 0 0` and use the translation transform (or map) to your desired origin coordinates.
This allows you to do things like rotate a Cube, Circle, etc. around a point.

For all renderers visit [Renderer.kt](https://github.com/Project-Cepi/Particable/blob/main/Minestom/src/main/kotlin/world/cepi/particle/Renderer.kt)
