package com.fiskerz.bundlycoins;

import com.fiskerz.bundlycoins.coins.Coins;
import com.fiskerz.bundlycoins.pouches.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class CreativeModeModTab {

    public static final DeferredRegister<net.minecraft.world.item.CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BundlyCoins.MODID);

    public static final Supplier<CreativeModeTab> CREATIVE_ITEMS_TAB = CREATIVE_MODE_TAB.register("creative_items_tab", () -> net.minecraft.world.item.CreativeModeTab.builder().icon(() -> new ItemStack(DiamondPouches.SMALLDIAMONDPOUCH.get()))
            .title(Component.translatable("creativetab.bundlycoins.coin_items"))
            .displayItems((itemDisplayParameters, output) -> {
                output.accept(Coins.COPPERCOIN);
                output.accept(Coins.IRONCOIN);
                output.accept(Coins.GOLDCOIN);
                output.accept(Coins.DIAMONDCOIN);
                output.accept(Coins.NETHERITECOIN);

                output.accept(BasicPouches.SMALLBASICPOUCH);
                output.accept(BasicPouches.BASICPOUCH);
                output.accept(BasicPouches.BIGBASICPOUCH);
                output.accept(BasicPouches.HUGEBASICPOUCH);
                output.accept(CopperPouches.SMALLCOPPERPOUCH);
                output.accept(CopperPouches.BIGCOPPERPOUCH);
                output.accept(IronPouches.SMALLIRONPOUCH);
                output.accept(IronPouches.BIGIRONPOUCH);
                output.accept(GoldPouches.SMALLGOLDPOUCH);
                output.accept(GoldPouches.MEDIGOLDPOUCH);
                output.accept(GoldPouches.BIGGOLDPOUCH);
                output.accept(DiamondPouches.SMALLDIAMONDPOUCH);
                output.accept(DiamondPouches.MEDIDIAMONDPOUCH);
                output.accept(DiamondPouches.BIGDIAMONDPOUCH);
                output.accept(DiamondPouches.LARGEDIAMONDPOUCH);
                output.accept(NetheritePouches.SMALLNETHERITEPOUCH);
                output.accept(NetheritePouches.MEDINETHERITEPOUCH);
                output.accept(NetheritePouches.BIGNETHERITEPOUCH);
                output.accept(NetheritePouches.LARGENETHERITEPOUCH);
                output.accept(SpecialPouches.RUBYNETHERITEPOUCH);
            }).build());

    public static void register(IEventBus cTabEventBus) {
        CREATIVE_MODE_TAB.register(cTabEventBus);
    }
}
