package fiveavian.proxvc.mixin.client;

import net.minecraft.client.option.GameSettings;
import net.minecraft.client.sound.SoundManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

/**
 * Ensures that Minecraft doesn't crash
 * when starting the game with no volume.
 */
@Mixin(value = SoundManager.class, remap = false)
public class SoundManagerMixin {
    @Redirect(method = "loadSoundSettings", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/sound/SoundCategoryHelper;isAnyEnabled(Lnet/minecraft/client/option/GameSettings;)Z"))
    public boolean isAnyEnabled(GameSettings category) {
        return true;
    }
}
