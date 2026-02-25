<!-- .github/copilot-instructions.md -->
# Copilot / AI Agent Instructions for this repo

Purpose: Help an AI coding agent become immediately productive editing and extending this small Java alert system.

Big picture
- This is a tiny Java project demonstrating a pluggable notification system: a central `AlertSystem` holds a `NotificationMedium` and a message log.
- Messages are delivered by instances of classes that implement the `NotificationMedium` interface. See key implementations in the repository.

Key files
- AlertSystem: [AlertSystem.java](AlertSystem.java#L1-L200) — main orchestration, `messageLog`, and `notifyUser()`.
- Interface: [NotificationMedium.java](NotificationMedium.java#L1-L200) — single method `void send(String message)`.
- Implementations: [EmailService.java](EmailService.java#L1-L200), [SMSService.java](SMSService.java#L1-L200).

Run & build
- Compile and run from the repo root using the JDK toolchain:

```bash
javac AlertSystem.java
java AlertSystem
```

Important behavioral notes (observed from code)
- `AlertSystem.notifyUser(...)` calls `medium.send(message)` then appends the message to `messageLog` — the code assumes `medium` has been set before `notifyUser` is called. If `medium` is null, a `NullPointerException` will occur.
- `messageLog` is an in-memory `ArrayList<String>` kept per-process; there is no persistence or external integration.
- There are no external dependencies, build tools, or tests present in the repository.

Conventions & patterns specific to this repo
- Single-method interface pattern: new notification channels should implement `NotificationMedium` and override `send(String message)`.
- Keep public API signatures stable: do not change `NotificationMedium.send`, `AlertSystem.notifyUser`, or `AlertSystem.getMessageLog()` without explicit justification and tests.
- Preserve author/version header style when adding new files (file-level Javadoc with `@author` and `@version`).

How to add a new notification medium (example)
- Create a new class that implements `NotificationMedium` and override `send`.

Example: add `PushService.java` (conceptual):

```java
public class PushService implements NotificationMedium {
    @Override
    public void send(String message) {
        System.out.println("Push notification: " + message);
    }
}
```

- Then in `AlertSystem.main()` or test code call `alertSystem.setMedium(new PushService());` before `notifyUser(...)`.

Editing guidance for AI agents
- Preserve existing program flow in `AlertSystem.main()` — it's used as a runnable example showcasing medium swapping and log behavior.
- If adding null-safety (guarding `medium` in `notifyUser`), prefer a clear behavior: either throw a descriptive `IllegalStateException` with a short message or add a no-op medium. Document the choice in the commit message and update the Javadoc.
- Keep changes small and focused: this repo is pedagogical and likely used for demonstration, so avoid introducing heavy frameworks or build configs unless requested.

What NOT to change without approval
- Do not add new public APIs that change method signatures used across files.
- Do not remove `messageLog` or change it to a different contract without adding tests and updating `main()` examples.

Missing / suggested improvements (note for the human maintainer)
- Add a small test harness (JUnit) if you want to validate new mediums and behaviors.
- Consider adding a `NullNotificationMedium` or explicit guard in `notifyUser` to make behavior clearer.

Questions for the repo owner
- Do you want null-safety for `AlertSystem.notifyUser` (throw vs no-op)?
- Would you like tests and a minimal `build` (Maven/Gradle) added?

If anything above is unclear or you'd like a different format (short checklist, PR template, or added tests), tell me which sections to expand or modify.
