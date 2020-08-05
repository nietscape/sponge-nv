package io.github.nietscape.spongenv;

import com.google.inject.Inject;
import org.slf4j.Logger;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.plugin.Plugin;

@Plugin(
        id = "sponge-nv",
        name = "Sponge NV"
)
public class SpongeNV {

    @Inject
    private Logger logger;
    @Inject
    private PluginContainer container;

    @Listener
    public void onGameInit(GameStartedServerEvent event) {
        logger.info("Hello!");
        CommandSpec nvSpec = CommandSpec.builder()
                .description(Text.of("Enabled Night Vision"))
                .permission("sponge-nv.nv")
                .executor(new NVCommand())
                .build();
        Sponge.getCommandManager().register(container, nvSpec, "nv", "nightvision", "night_vision");

        CommandSpec nvOff = CommandSpec.builder()
                .description(Text.of("Turns Night Vision off"))
                .permission("sponge-nv.nvoff")
                .executor(new NVOffCommand())
                .build();
        Sponge.getCommandManager().register(container, nvOff, "nvoff");

        CommandSpec removeEffectsSpec = CommandSpec.builder()
                .description(Text.of("Disables all potion effects"))
                .permission("sponge-nv.remove_effects")
                .executor(new RemoveEffectsCommand())
                .build();
        Sponge.getCommandManager().register(container, removeEffectsSpec, "remove_effects");
    }

}
