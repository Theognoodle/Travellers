package mod.iris.travellers.common.registry;

import mod.iris.travellers.Travellers;
import mod.iris.travellers.common.registry.custom.AethericShardItem;
import mod.iris.travellers.common.registry.custom.FleshPactItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.openjdk.nashorn.internal.ir.Block;

public class TravellersItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Travellers.MODID);


    public static final RegistryObject<Item> PACT_FLESHY = ITEMS.register("flesh_pact",
            () -> new FleshPactItem(new Item.Properties()));


    public static final RegistryObject<Item> PACT_AETHERIC = ITEMS.register("aetheric_shard",
            () -> new AethericShardItem(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }



}
