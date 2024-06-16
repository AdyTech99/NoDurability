package com.adytechmc.nodurability.mixin;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.component.ComponentType;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Environment(EnvType.CLIENT)
@Mixin(ItemStack.class)
public abstract class ClientMixin {

    @Shadow @Nullable public abstract <T> T set(ComponentType<? super T> type, @Nullable T value);

    @Inject(
            method = "setDamage",
            at = @At("TAIL"),
            cancellable = true
    )
    public void setDamage(int damage, CallbackInfo ci) {
        if(MinecraftClient.getInstance() != null) {
            if (MinecraftClient.getInstance().isInSingleplayer()) {
                this.set(DataComponentTypes.DAMAGE, 0);
                ci.cancel();
            }
        }
    }
}
