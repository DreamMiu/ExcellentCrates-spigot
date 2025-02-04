package su.nightexpress.excellentcrates.editor;

import org.jetbrains.annotations.NotNull;
import su.nexmedia.engine.api.menu.impl.EditorMenu;
import su.nexmedia.engine.utils.ItemUtil;
import su.nightexpress.excellentcrates.ExcellentCrates;
import su.nightexpress.excellentcrates.config.Config;
import su.nightexpress.excellentcrates.crate.editor.CrateListEditor;
import su.nightexpress.excellentcrates.key.editor.KeyListEditor;

public class EditorMainMenu extends EditorMenu<ExcellentCrates, ExcellentCrates> {

    private static final String TEXTURE_CRATE = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTZkN2ZkYjUwZjE0YzczMWM3MjdiMGUwZDE4OWI2YTg3NDMxOWZjMGQ3OWM4YTA5OWFjZmM3N2M3YjJkOTE5NiJ9fX0=";
    private static final String TEXTURE_KEY = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYWVlZmE0Y2QyYTU1OGU0YTgxMmUyZWE3NTQxZTYyNzUwYjk2YmExZDgyYzFkYTlmZDVmMmUzZmI5MzA4YzYzNSJ9fX0=";

    private CrateListEditor crateListEditor;
    private KeyListEditor   keyListEditor;

    public EditorMainMenu(@NotNull ExcellentCrates plugin) {
        super(plugin, plugin, Config.EDITOR_TITLE_CRATE.get(), 27);

        this.addExit(22);

        this.addItem(ItemUtil.createCustomHead(TEXTURE_CRATE), EditorLocales.CRATES_EDITOR, 11)
            .setClick((viewer, event) -> {
                this.plugin.runTask(task -> this.getCratesEditor().open(viewer.getPlayer(), 1));
            });
        this.addItem(ItemUtil.createCustomHead(TEXTURE_KEY), EditorLocales.KEYS_EDITOR, 15)
            .setClick((viewer, event) -> {
                this.plugin.runTask(task -> this.getKeysEditor().open(viewer.getPlayer(), 1));
            });
    }

    @Override
    public void clear() {
        if (this.crateListEditor != null) {
            this.crateListEditor.clear();
            this.crateListEditor = null;
        }
        if (this.keyListEditor != null) {
            this.keyListEditor.clear();
            this.keyListEditor = null;
        }
        super.clear();
    }

    @NotNull
    public CrateListEditor getCratesEditor() {
        if (this.crateListEditor == null) {
            this.crateListEditor = new CrateListEditor(this.plugin.getCrateManager());
        }
        return this.crateListEditor;
    }

    @NotNull
    public KeyListEditor getKeysEditor() {
        if (this.keyListEditor == null) {
            this.keyListEditor = new KeyListEditor(this.plugin.getKeyManager());
        }
        return this.keyListEditor;
    }
}
